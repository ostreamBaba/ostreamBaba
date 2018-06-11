package com.multithreading.GuardedSuspension;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ Create by ostreamBaba on 18-6-11
 * @ 描述
 */
public class RequestQueue1 {
    private final BlockingQueue<Request> queue=new LinkedBlockingDeque<Request>();//线程安全的队列
    public Request getRequest(){
        Request request=null;
        try{
            request=queue.take();
            //获取并移除此队列的头部，如果没有元素则等待（阻塞），
            //直到有元素将唤醒等待线程执行该操作
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return request;
    }

    public void putRequest(Request request){
        try {
            queue.put(request);
            //将指定的元素插入此队列的尾部，
            //如果该队列已满，则一直等待（阻塞）
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //take用于取出对首元素 put用于向队列末尾添加元素
    //take put 已经考虑互斥 所以不需要加锁
}
