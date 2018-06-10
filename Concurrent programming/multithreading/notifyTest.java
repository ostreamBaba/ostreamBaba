package com.multithreading;

import org.apache.http.annotation.ThreadSafe;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ ??
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

    public static void main(String[] args) {

    }


}


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
                        shareObj.wait();
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
                shareObj.notifyAll();
                System.out.println("线程 "+this.getName()+" 通知结束");
            }
            System.out.println("线程 "+this.getName()+" 结束运行");
        }
    }



    public static void main(String[] args) {
        WaitNotifyTest test=new WaitNotifyTest();
        ThreadWait threadWait1=test.new ThreadWait("wait thread1");
        threadWait1.setPriority(2);
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