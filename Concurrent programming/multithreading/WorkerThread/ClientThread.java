package com.multithreading.WorkerThread;

import java.util.Random;

/**
 * @ Create by ostreamBaba on 18-6-13
 * @ 发送工作请求的类
 */
public class ClientThread extends Thread{
    private final Channel channel;
    private static final Random RANDOM=new Random();

    public ClientThread(String s, Channel channel) {
        super( s );
        this.channel = channel;
    }

    @Override
    public void run() {
        for (int i = 0; true; i++) {
            try {
                Request request=new Request (getName(),i);
                channel.putRequest(request);
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
