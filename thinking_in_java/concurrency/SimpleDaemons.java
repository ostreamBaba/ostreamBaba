package com.ostream.ThinkingInJavaII.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @Create by ostreamBaba on 18-4-28
 * @描述
 */

//后台线程： 指在程序运行的时候在后台提供的一种通用服务的线程 并且这种线程并不属于程序中不可或缺的部分
//当所有的非后台线程结束时 程序也就终止了 同时会杀死进程中所有的后台线程
public class SimpleDaemons implements Runnable{

    @Override
    public void run() {
        try{
            while (true){ //在非后台线程结束时一共打印了10次
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            }
        }catch (InterruptedException e){
            System.err.println("interrupted");
        }
    }
    //建立了显示的线程 以便设置他们的后台标志
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon=new Thread(new SimpleDaemons());
            daemon.setDaemon(true);  //把线程设为后台线程
            daemon.start();
        }
        System.out.println("All daemon start");
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
