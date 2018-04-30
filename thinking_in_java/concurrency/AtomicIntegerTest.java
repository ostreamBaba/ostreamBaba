package com.ostream.ThinkingInJavaII.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Create by ostreamBaba on 18-4-30
 * @描述
 */


//原子类 ??????
public class AtomicIntegerTest implements Runnable{
    private AtomicInteger i=new AtomicInteger(0);
    public int getValue(){
        return i.get();
    }
    private void evenIncrement(){
        i.addAndGet(2); //原子性
    }
    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Aborting");
                System.exit(0);
            }
        },5000); //5秒之后自动终结
        ExecutorService exec= Executors.newCachedThreadPool();
        AtomicIntegerTest ait=new AtomicIntegerTest();
        exec.execute(ait);
        exec.shutdown();
        while (true){
            int val=ait.getValue();
            if(val%2!=0){
                System.out.println(val+" no even");
                System.exit(0);
            }
        }
    }
}
