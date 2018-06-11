package com.multithreading.GuardedTimed;

import java.util.concurrent.TimeoutException;

/**
 * @ Create by ostreamBaba on 18-6-11
 * @ Guarded Timed的实现(使用wait) wait传入0 表示没有超时时间 即超时时间无限长 传入负数则抛出异常
 */
public class Host {

    private final long timeout;
    private boolean ready=false;

    public Host(long timeout) {
        this.timeout = timeout;
    }

    public synchronized void setExecutable(boolean on){
        ready=on;
        notifyAll();
    }

    //判断wait是否超时的方法
    public synchronized void execute()throws InterruptedException,TimeoutException{
        long start=System.currentTimeMillis(); //开始时间
        while (!ready){
            long now=System.currentTimeMillis(); //当前时间
            long rest=timeout-(now-start); //剩余等待时间
            if(rest<=0){
                throw new TimeoutException("now-start="+(now-start)+",timeout="+timeout);
            }
            wait(rest);
        }
        doExecute();
    }

    private void doExecute() {
        System.out.println(Thread.currentThread().getName()+" calls doExecute");
    }
}
