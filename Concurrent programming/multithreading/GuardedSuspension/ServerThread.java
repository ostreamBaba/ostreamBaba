package com.multithreading.GuardedSuspension;

import java.util.Random;

/**
 * @ Create by ostreamBaba on 18-6-11
 * @ ·þÎñ¶Ë
 */
public class ServerThread extends Thread{
    private final Random random;
    /*private final RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue,String name,long seed) {
        super(name);
        this.random=new Random(seed);
        this.requestQueue = requestQueue;
    }*/
    private final RequestQueue1 requestQueue;

    public ServerThread(RequestQueue1 requestQueue,String name,long seed) {
        super(name);
        this.random=new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request=requestQueue.getRequest();
            System.out.println(Thread.currentThread().getName()+" handle "+request);
            try {
                Thread.sleep(random.nextInt(1000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
