package com.multithreading;

import org.apache.http.annotation.ThreadSafe;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ 描述
 */


@ThreadSafe
public class notifyTest {

    public void method(){
        synchronized (this){
            System.out.println("即将执行wait方法");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public void method2(){
        synchronized (this){
            System.out.printf("即将执行notify方法");
            this.notify();
        }
    }
}



/*AQS的实现是这样的：存在两个队列，sync队列和condition队列。争抢lock的所有线程都在sync队列上，
        await之后的线程从sync队列移出并挂到condition队列上，同时释放lock。
        condition队列上的某个线程收到signal之后会重新挂到sync队列上，
        并和sync队列上已有的其他线程一起竞争lock。如果是signalAll，
        那么就是把condition队列上的所有线程都挂到sync队列上来。
        Object.wait/notify是jvm的内部实现，因此上面关于AQS的说明可以作为参考。
        被notify后的线程处于blocking或者runnable状态，其他wait线程依然是waiting状态。*/


class WaitNotifyTest{

    private String[] shareObj={"true"};

    class ThreadWait extends Thread{
        public ThreadWait(String name) {
            super( name );
        }

        @Override
        public void run() {
            synchronized (shareObj){
                while ("true".equals(shareObj[0])){
                    System.out.println("thread "+this.getName()+" start");
                    long startTime=System.currentTimeMillis();
                    try{
                        System.out.println("将线程 "+this.getName()+" 加入shareObj的等待队列,并释放当前线程所占有的shareObj实例的锁");
                        shareObj.wait(10000); //设置wait时间
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    System.out.println("退出等待队列的线程获取锁,执行wait方法的下一个操作");
                    long endTime=System.currentTimeMillis();
                    System.out.println("Thread "+this.getName()+" time： "+(endTime-startTime));
                    Thread.yield();
                }
                System.out.println("Thread "+this.getName()+" end");
            }
        }
    }

    class ThreadNotify extends Thread{
        public ThreadNotify(String name) {
            super( name );
        }

        @Override
        public void run() {
            try {
                sleep(3000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("线程即将获得shareObj实例的锁");
            synchronized (shareObj){
                System.out.println("线程 "+this.getName()+" 准备通知");
                shareObj[0]="false";
                //shareObj.notify();
                shareObj.notifyAll();
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程 "+this.getName()+" 通知结束");
            }
            System.out.println("线程 "+this.getName()+" 结束运行");
        }
    }



    public static void main(String[] args) {
        WaitNotifyTest test=new WaitNotifyTest();

        ThreadWait threadWait1=test.new ThreadWait("wait thread1");
        threadWait1.setPriority(8);
        ThreadWait threadWait2=test.new ThreadWait("wait thread2");
        threadWait2.setPriority(3);
        ThreadWait threadWait3=test.new ThreadWait("wait thread3");
        threadWait3.setPriority(4);

        ThreadNotify threadNotify = test.new ThreadNotify("notify thread");

        threadNotify.start();
        threadWait1.start();
        threadWait2.start();
        threadWait3.start();
    }

}