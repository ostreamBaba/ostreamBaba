package com.multithreading.ThreadPerMessage;


import java.util.concurrent.Executor;

/**
 * @ Create by ostreamBaba on 18-6-13
 * @ 描述
 */
public class Host2 {
    private final Helper helper=new Helper();
    private final Executor executor;

    public Host2(Executor executor) {
        this.executor = executor;
    }

    //前面ThreadFactory隐藏了线程创建的细节 但并未隐藏创建线程的操作
    //使用了Executor的Host2类 创建线程的操作也被隐藏了起来
    public void request(final int count, final char c){
        System.out.println(" request("+count+", "+c+") BEING");
        executor.execute(new Runnable() {
            @Override
            public void run() {
                helper.handle(count,c);
            }
        } );
        System.out.println(" request("+count+", "+c+") END");
    }
}
