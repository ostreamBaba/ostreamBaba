package com.multithreading.doSomeTest;

/**
 * @ Create by ostreamBaba on 18-6-11
 * @ 多次start一个线程会抛出java.lang.IllegalThreadStateException(线程状态非法异常)异常
 * @ It is never legal to start a thread more than once.多次调用start方法启动一个线程是非法的
 */
public class threadStatusTest {
    public static void main(String[] args) {
        Thread thread = new TestThread();
        /*while (true){
            thread.start();
        }*/
        thread.start();
        thread.start();
        //经过debug
        // if (this.threadStatus != 0) {
        //    throw new IllegalThreadStateException();
        // }
        // A zero status value corresponds to state "NEW". 说明thread第二次start时候的状态值已经不是0了
        // 线程五种周期： 新建->就绪->运行->死亡->堵塞
    }
}


class TestThread extends Thread{
    @Override
    public void run() {
        System.out.println("BEING");
        for (int i = 0; i < 50; i++) {
            try{
                System.out.println(".");
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("END");
    }
}


