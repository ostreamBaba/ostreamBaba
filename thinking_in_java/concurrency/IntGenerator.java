package com.ostream.ThinkingInJavaII.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Create by ostreamBaba on 18-4-29
 * @描述
 */
//共享受限资源
public abstract class IntGenerator {
    private volatile boolean canceled=false;
    public abstract int next();
    public void cancel(){
        canceled=true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}

class EvenChecker implements Runnable{
    private IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }
    @Override
    public void run() {
        //一个任务不能依赖于另一个任务 因为任务关闭的顺序无法得到保证
        //通过使任务依赖于非任务对象 我们可以消除潜在的竞争条件
        while (!generator.isCanceled()){
            int val=generator.next();
            if(val%2!=0){
                System.out.println(val+" not even!");
                generator.cancel();
            }
            //System.out.println(val);
        }
    }
    public static void test(IntGenerator gp,int count){
        ExecutorService exec= Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp,i));
        }
        exec.shutdown();
    }
    //test方法通过启动大量相同IntGenerator的EvenChecker 设置并执行对任何类型的IntGenerator的测试
    public static void test(IntGenerator gp){
        test(gp,10);
    }
}

class EventGenerator extends IntGenerator{
    private int currentEventValue=0;
    @Override
    public int next() {
        //一个任务可能在另一个任务执行对第一个currentEventValue的递增操作之后
        //但没有执行第二个递增之前 调用next方法 这样使得这个值处于"不恰当"的状态
        //并发程序的部分问题--如果失败概率非常低 即使存在缺陷 他们也可能看起来是正确的
        //递增程序自身也需要多个1步骤 并且在递增过程中递增任务会被线程机制挂起
        //也就是说 递增不是原子性的操作 如果不保护任务 即使是单一的递增也不安全
        ++currentEventValue; //danger point here
        Thread.yield();
        ++currentEventValue;
        return currentEventValue;
    }
    public static void main(String[] args) {
        EvenChecker.test(new EventGenerator());
    }
}

//同步控制
class SynchronizedEvenGenerator extends IntGenerator{
    private int currentEvenValue=0;
    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield(); //提高上下文切换的可能性
        ++currentEvenValue;
        return currentEvenValue;
    }
    //因为互斥可以防止多个任务同时进入临界区 所以不会产生任何失败
    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}

//使用显示的Lock对象
class MutexEvenGenerator extends IntGenerator{
    private int currentEvenValue=0;
    private Lock lock=new ReentrantLock();
    @Override
    public int next() {
        lock.lock();//加锁
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        }finally {
            lock.unlock(); //解锁
        }
    }
    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}

//synchronized关键字不能尝试着获取锁且最终获取锁失败 或者尝试着获取一段时间然后放弃它

class AttemptLocking{
    private ReentrantLock lock=new ReentrantLock();
    public void untimed(){
        boolean captured=lock.tryLock();
        try{
            System.out.println("tryLock(): "+captured);
        }finally {
            if(captured){
                lock.unlock();
            }
        }
    }
    public void timed(){
        boolean captured=false;
        try{
            captured=lock.tryLock(2, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
        try{
            System.out.println("tryLock(x,y): "+captured);
        }finally {
            if(captured){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al=new AttemptLocking();
        al.untimed();
        al.timed();
        new Thread(){
            {
                setDaemon(true);
            }
            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        }catch (InterruptedException e){ }
        //Thread.yield();
        al.untimed();
        al.timed();
    }
}