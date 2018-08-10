package com.multithreading.WorkerThread;

import java.util.Random;

/**
 * @ Create by ostreamBaba on 18-6-13
 * @ 表示工作请求的Request类
 */
public class Request {
    private final String name;
    private final int number;
    private static final Random RANDOM=new Random();
    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    //负责处理请求的方法
    public void execute(){
        System.out.println(Thread.currentThread().getName()+" execute"+this);
        try {
            Thread.sleep(RANDOM.nextInt(1000));//模拟处理请求的这段时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "[ Request from "+name+" No. "+number+" ]";
    }
}
