package com.multithreading.WorkerThread;

/**
 * @ Create by ostreamBaba on 18-8-10
 * @ 表示工人线程的类
 */
public class WorkerThread extends Thread{

    private final Channel channel;

    public WorkerThread(String name,Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true){
            Request request=channel.takeRequest();
            request.execute();
        }
    }
}
