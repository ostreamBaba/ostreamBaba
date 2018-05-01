package com.ostream.ThinkingInJavaII.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Create by ostreamBaba on 18-4-30
 * @描述
 */


//线程本地储存是一种自动化机制 可以为使用相同变量的每个不同的线程都创建不同的存储
//如果你有5个线程都需要使用到变量x所表示的对象 那么线程本地储存就会生成五个用于x的不同的存储块
public class Accessor implements Runnable{
    private final int id;
    public Accessor(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }
    @Override
    public String toString() {
        return "#"+id+": "+ThreadLocalVariableHolder.get();
    }
}
class ThreadLocalVariableHolder{
    private static ThreadLocal<Integer> value=new ThreadLocal<Integer>(){
        private Random random=new Random(47);
        @Override
        protected synchronized Integer initialValue() {
            return random.nextInt(100);
        }
    };
    //increment()和get()方法都不是synchronized的 因为ThreadLocal保证不会出现竞争条件
    public static void increment(){
        value.set(value.get()+1);
    }
    public static int get(){
        return value.get();
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec= Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }
}



//shutdown与shutdownNow区别
class TestShutdown{

    public static void testShutdown(int StartNo) throws InterruptedException {
        ExecutorService exec=Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            exec.execute(getTast(i+StartNo));
        }
        exec.shutdown();
        if(!exec.awaitTermination(1,TimeUnit.DAYS)){
            System.out.println("not close");
        }
        System.out.println("close");
    }

    public static void testShutdownNow(int StartNo) throws InterruptedException {
        ExecutorService exec=Executors.newFixedThreadPool(4);
        for (int i = 0; i < 5; i++) {
            exec.execute(getTast(i+StartNo));
        }
        exec.shutdownNow();
        if(!exec.awaitTermination(1,TimeUnit.DAYS)){
            System.out.println("not close");
        }
        System.out.println("close");
    }

    public static Runnable getTast(int ThreadNo){
        final Random random=new Random();
        final int no=ThreadNo;
        Runnable task=new Runnable(){
            @Override
            public void run() {
                try{
                    System.out.println("NO "+no+"-->"+random.nextInt(10));
                    TimeUnit.MILLISECONDS.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println("Thread "+no+" has error "+e);
                }
            }
        };
        return task;
    }

    public static void main(String[] args) {
        try{
            testShutdown(100);
            testShutdownNow(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
//shutdownNow()
/*将线程池状态置为STOP。企图立即停止，事实上不一定：
    跟shutdown()一样，先停止接收外部提交的任务
    忽略队列里等待的任务
    尝试将正在跑的任务interrupt中断
    返回未执行的任务列表
    它试图终止线程的方法是通过调用Thread.interrupt()方法来实现的，但是大家知道，这种方法的作用有限，如果线程中没有sleep 、wait、Condition、定时锁等应用, interrupt()方法是无法中断当前的线程的。所以，ShutdownNow()并不代表线程池就一定立即就能退出，它也可能必须要等待所有正在执行的任务都执行完成了才能退出。
    但是大多数时候是能立即退出的
*/




class TestShutDown {
    public static void main(String[] args) {
        try {
            testShutDown(100);
            testShutDowNow(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testShutDown(int startNo) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            executorService.execute(getTask(i + startNo));
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("shutDown->all thread shutdown");
    }

    public static void testShutDowNow(int startNo) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            executorService.execute(getTask(i + startNo));
        }
        executorService.shutdownNow();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("shutdownNow->all thread shutdown");
    }

    public static Runnable getTask(int threadNo) {
        final Random rand = new Random();
        final int no = threadNo;
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(no + "-->" + rand.nextInt(10));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("thread " + no + " has error" + e);
                }
            }
        };
        return task;
    }
}