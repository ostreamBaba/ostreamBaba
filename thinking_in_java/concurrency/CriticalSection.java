package com.ostream.ThinkingInJavaII.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Create by ostreamBaba on 18-4-30
 * @描述
 */

//临界区
class Pair{  //not thread-safe
    private int x,y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Pair() {
        this(0,0);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void incrementX(){
        x++;
    }
    public void incrementY(){
        y++;
    }
    @Override
    public String toString() {
        return "x: "+x+",y: "+y;
    }
    public class PairValuesEqualException extends RuntimeException{
        public PairValuesEqualException() {
            super("Pair values not equal: "+Pair.this);
        }
    }
    public void checkState(){
        if(x!=y){
            throw new PairValuesEqualException();
        }
    }
}
//将一些功能在基类中实现 并且其一个或者多个抽象方法在派生类中定义 这种在设计模式中称为模板方法
abstract class PairManager{
    AtomicInteger checkCounter=new AtomicInteger(0);
    protected Pair p=new Pair();
    private List<Pair> storage= Collections.synchronizedList(new ArrayList<Pair>());
    public synchronized Pair getPair() {
        return new Pair(p.getX(),p.getY());
    }
    protected void store(Pair p){
        storage.add(p);
        try{
            TimeUnit.MILLISECONDS.sleep(5);
        }catch (InterruptedException e){}
    }
    public abstract void increment();
}

class PairManager1 extends PairManager{
    //整个increment被同步控制
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

class PairManager2 extends PairManager{
    //使用同步控制块进行同步
    @Override
    public void increment() {
        Pair temp;
        synchronized(this){
            p.incrementX();
            p.incrementY();
            temp=getPair(); //保证线程安全
        }
        store(temp); //将一个Pair对象放进synchronized ArrayList里 这个操作是线程安全的
    }
}
//在某个任务里调用increment()方法
class PairManipulator implements Runnable{
    private PairManager pm;
    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }
    @Override
    public void run() {
        while (true){
            pm.increment();
        }
    }
    @Override
    public String toString() {
        return "Pair: "+pm.getPair()+" checkCounter="+pm.checkCounter.get();
    }
}

class PairChecker implements Runnable{
    private PairManager pm;
    public PairChecker(PairManager pm) {
        this.pm = pm;
    }
    @Override
    public void run() {
        while (true){
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}

public class CriticalSection {
    static void test(PairManager pman1,PairManager pman2){
        ExecutorService exec= Executors.newCachedThreadPool();
        PairManipulator pm1=new PairManipulator(pman1);
        PairManipulator pm2=new PairManipulator(pman2);
        PairChecker pc1=new PairChecker(pman1);
        PairChecker pc2=new PairChecker(pman2);
        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pc1);
        exec.execute(pc2);
        //exec.shutdown();
        try{
            TimeUnit.MILLISECONDS.sleep(500);
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println("pm1: "+pm1+"\npm2: "+pm2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager pman1=new PairManager1();
        PairManager pman2=new PairManager2();
        test(pman1,pman2);
        //PairChecker的检查频率 前者没有后者多 后者采用了同步控制块进行同步 所以对象不加锁的时间更长
        //使用同步控制块是为了 使得线程能更多的访问(在安全的情况下尽可能多)
    }
}


class ExplicitPairManager1 extends PairManager{
    private Lock lock=new ReentrantLock();
    @Override
    public synchronized void increment() {
        lock.lock();
        try{
            p.incrementY();
            p.incrementX();
            store(getPair());
        }finally {
            lock.unlock();
        }
    }
}

//????????????????????????????????
//lock锁失效??
class ExplicitPairManager2 extends PairManager{
    private Lock lock=new ReentrantLock();
    @Override
    public void increment() {
        lock.lock();
        Pair tmp;
        try{
            p.incrementX();
            p.incrementY();
            tmp=getPair();
        }finally {
            lock.unlock();
        }
        store(tmp);
    }
}
class ExplicitCriticalSection{
    public static void main(String[] args) {
        PairManager pman1=new ExplicitPairManager1();
        PairManager pman2=new ExplicitPairManager2();
        CriticalSection.test(pman1,pman2);
    }
}