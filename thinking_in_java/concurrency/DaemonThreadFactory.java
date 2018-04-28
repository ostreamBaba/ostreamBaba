package com.ostream.ThinkingInJavaII.concurrency;

import java.util.concurrent.*;

/**
 * @Create by ostreamBaba on 18-4-28
 * @描述
 */

//把后台状态都设置为true  可以定制由Executor创建的线程的属性(后台 属性 名称)
public class DaemonThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread=new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }
}

class DaemonFromFactory implements Runnable{
    @Override
    public void run() {
        try{
            while (true){
                System.out.println(Thread.currentThread()+" "+this);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.err.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec= Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("all daemons started");
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}

class DaemonThreadPoolExecutor extends ThreadPoolExecutor{
    public DaemonThreadPoolExecutor() {
        super(0,Integer.MAX_VALUE,60L,TimeUnit.SECONDS,new SynchronousQueue<Runnable>(),new DaemonThreadFactory());
    }
}



//如果该线程是后台线程 那么他创建的任何线程都将自动被设置为后台线程

class Daemon implements Runnable{
    private Thread[] t=new Thread[10];
    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i]=new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("daemonSpawn "+i+" start");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("[t"+i+"].isDaemom()="+t[i].isDaemon());
        }
        while (true){
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable{
    @Override
    public void run() {
        //System.out.println("daemonSpawn");
        Thread.yield();
    }
}


class Daemons{
    public static void main(String[] args) throws InterruptedException {
        Thread d=new Thread(new Daemon());
        d.setDaemon(true);//将Daemons线程设置为后台模式 派生出很对子线程(没有显示地设置为后台模式 可是的确是后台线程)
        d.start();
        System.out.println("d.isDaemon()="+d.isDaemon());
        TimeUnit.SECONDS.sleep(1);
    }
}


//finally 并不会得到执行 一旦非后台线程
//当最后一个非后台线程终止时 后台线程会突然突然终止
class ADaemon implements Runnable{
    @Override
    public void run() {
        try{
            System.out.println("start");
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            System.out.println(e);
        }finally {
            System.out.println("run???");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        System.out.println("??");
        //TimeUnit.SECONDS.sleep(1);
    }
}