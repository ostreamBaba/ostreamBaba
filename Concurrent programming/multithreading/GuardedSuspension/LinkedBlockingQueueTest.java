package com.multithreading.GuardedSuspension;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ Create by ostreamBaba on 18-6-11
 * @ 描述
 */
public class LinkedBlockingQueueTest {

    private final BlockingQueue<Request> queue=new LinkedBlockingDeque<Request>();//线程安全的队列
    public Request getRequest(){
        Request request=null;
        try{
            request=queue.take();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return request;
    }

    public void putRequest(Request request){
        try {
            queue.put(request);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
