package com.multithreading.GuardedSuspension;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Create by ostreamBaba on 18-6-11
 * @ Guarded(被守护的)Suspension(暂停)
 */
public class RequestQueue {
    private final Queue<Request> queue=new LinkedList<Request>();

    public synchronized Request getRequest() {
        //客户端线程获取请求 当队列为空的话 那么就将该线程加入等待队列
        //使用队列FIFO先进先出处理请求
        while (queue.peek()==null){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request){
        queue.offer(request);
        /*this.notify();*/
        this.notifyAll();
        //当有请求put进队列的时候唤醒condition队列的所有线程 加入sync队列上,对lock进行竞争
    }
}
