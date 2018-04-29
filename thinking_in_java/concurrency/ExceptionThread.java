package com.ostream.ThinkingInJavaII.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Create by ostreamBaba on 18-4-29
 * @描述
 */

//异常逃出任务的run方法 向外传播到控制台
public class ExceptionThread implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException();
    }
    public static void main(String[] args) {
        ExecutorService exec= Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}

//并没有捕获到线程中抛出的异常
class NativeExceptionHandling{
    public static void main(String[] args) {
        try{
            ExecutorService exec=Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        }catch (Exception e){
            System.out.println("exception has been handled！");
        }
    }
}


//捕获异常


class ExceptionThread2 implements Runnable{
    @Override
    public void run() {
        Thread t=Thread.currentThread();
        System.out.println("run by "+t);
        System.out.println("eh= "+t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
//UncaughtExceptionHandler会在线程因为捕获到异常而临近死亡时被调用
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println("caught "+throwable);
    }
}
class HandlerThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable runnable) {
        System.out.println(this+" creating new Thread");
        Thread t=new Thread(runnable);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());//为Thread对象附着一个异常处理器
        System.out.println("eh= "+t.getUncaughtExceptionHandler());
        return t;
    }
}
class CaptureUncaughtException{
    public static void main(String[] args) {
        ExecutorService exec=Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}

//如果代码中处处使用相同的异常处理器
//可以在Thread类中设置一个静态域 并将这个处理器设置为默认的未捕获异常处理器
class SettingDefaultException{
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec=Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread2());
    }
}