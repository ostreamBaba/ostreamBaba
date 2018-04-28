package com.ostream.ThinkingInJavaII.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Create by ostreamBaba on 18-4-28
 * @描述
 */


//休眠
public class SleepingTask extends LiftOff{

    @Override
    public void run() {
        while (countDown-->0){
            System.out.println(status());
            //语句打印后 每个任务都将要睡眠(即阻塞) 这使得线程调度器可以切换到另外一个线程 进而驱动另外一个任务
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            }catch (InterruptedException e){
                System.err.println("Interrupted");
            }
        }
    }
    public static void main(String[] args) {
        ExecutorService exec= Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
