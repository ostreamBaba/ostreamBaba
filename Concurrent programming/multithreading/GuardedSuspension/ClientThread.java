package com.multithreading.GuardedSuspension;

import java.util.Random;

/**
 * @ Create by ostreamBaba on 18-6-11
 * @ ¿Í»§¶Ë
 */
public class ClientThread extends Thread{
    private final Random random;
    /*private final RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue,String name,long seed) {
        super(name);
        this.random=new Random(seed);
        this.requestQueue = requestQueue;
    }*/

    private final RequestQueue1 requestQueue;

    public ClientThread(RequestQueue1 requestQueue,String name,long seed) {
        super(name);
        this.random=new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request=new Request("No."+i);
            System.out.println(Thread.currentThread().getName()+" requests "+request);
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
