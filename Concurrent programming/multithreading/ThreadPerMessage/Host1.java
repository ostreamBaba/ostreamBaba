package com.multithreading.ThreadPerMessage;

import java.util.concurrent.ThreadFactory;

/**
 * @ Create by ostreamBaba on 18-6-13
 * @ 描述
 */


//使用java.util.concurrent.ThreadFactory
//使用new创建Thread实例时 代码依赖于Thread类  我们无法控制创建线程的部分 可复用性比较低
//使用threadFactory来保存ThreadFactory对象 用threadFactory.newThread代替new Thread 这样依赖 只要替换赋值给threadFactory
//的ThreadFactory的对象 我们便可以控制线程的创建
public class Host1 {
    private final Helper helper=new Helper();
    private final ThreadFactory threadFactory;

    public Host1(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public void request(final int count,final char c){
        System.out.println(" request("+count+", "+c+") BEING");
        threadFactory.newThread(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count,c);
                    }
                }
        ).start();
        System.out.println(" request("+count+", "+c+") END");
    }
}
