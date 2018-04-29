package com.ostream.ThinkingInJavaII.concurrency;

/**
 * @Create by ostreamBaba on 18-4-29
 * @描述
 */

//任务类都实现了Runnable
//这里直接继承Thread
public class SimpleThread extends Thread{
    private int countDown=5;
    private static int threadCount=0;
    public SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }
    @Override
    public String toString() {
        return "#"+getName()+"("+countDown+")";
    }
    @Override
    public void run() {
        while (true){
            System.out.println(this);
            if(--countDown==0){
                return;
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
