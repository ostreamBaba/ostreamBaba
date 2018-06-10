package com.multithreading.SingleThreadedExecution;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ 表示计数信号量的类 Semaphore
 */
class Log{
    public static void println(String s){
        System.out.println(Thread.currentThread().getName()+": "+s);
    }
}

//资源个数有限
class BoundedResource{
    private final Semaphore semaphore;
    private final int permits;
    private final static Random RANDOM=new Random(314159);

    public BoundedResource(int permits) {
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    public void use() throws InterruptedException{ //使用一个可用资源
        semaphore.acquire(); //判断是否存在可用资源 当线程从acquire()线程返回时 则一定存在可用资源
        //若不存在可用资源 线程则阻塞在acquire方法内 直至出现可用资源
        try {
            doUse();
        }finally {
            semaphore.release(); //释放资源  Before/After模式
        }
    }

    protected void doUse() throws InterruptedException{
        Log.println("BEGIN: used= "+(permits-semaphore.availablePermits()));
        //permits-semaphore.availablePermits()表示当前正在用的资源数
        Thread.sleep(RANDOM.nextInt(5000));
        Log.println("END: used= "+(permits-semaphore.availablePermits()));
    }
}

class UserThread extends Thread{
    private final static Random RANDOM=new Random(26535);
    private final BoundedResource resource;

    public UserThread(BoundedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true){
            try {
                resource.use();
                TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(3000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class SemaphoreTest {
    public static void main(String[] args) {
        //设置三个资源
        BoundedResource resource=new BoundedResource(3);

        //模拟出现资源竞争
        for (int i = 0; i < 10; i++) {
            new UserThread(resource).start();
        }
    }
}
