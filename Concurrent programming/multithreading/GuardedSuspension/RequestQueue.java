package com.multithreading.GuardedSuspension;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Create by ostreamBaba on 18-6-11
 * @ Guarded(被守护的)Suspension(暂停)--> 附加条件的synchronized
 * @ GuardedObject 被守护的对象
 */
public class RequestQueue {
    private final Queue<Request> queue=new LinkedList<Request>();//LinkedList是非线程安全的

    public synchronized Request getRequest() {
        //客户端线程获取请求 当队列为空的话 那么就将该线程加入等待队列
        //使用队列FIFO先进先出处理请求
        while (queue.peek()==null){  //守护条件
            try {
                this.wait(); //线程在等待什么： 等待queue实例对象状态发生变化
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request){
        queue.offer(request);  //queue实例对象状态发生变化
        /*this.notify();*/
        this.notifyAll();
        //当有请求put进队列的时候唤醒condition队列的所有线程 加入sync队列上,对lock进行竞争
    }
}

/*
 java.lang.IllegalMonitorStateException 异常
 在同步控制方法或同步控制块里调用wait()，notify()和notifyAll()。
 如果在非同步控制方法里调用这些方法，程序能通过编译，
 但运行的时候，将得到IllegalMonitorStateException异常，
 并伴随着一些含糊的消息，比如"当前线程不是拥有者"。消息的意思是，
 调用wait()，notify()和notifyAll()的线程在调用这些方法前必须"拥有"对象的锁。
 当前的线程不是此对象锁的所有者，却调用该对象的notify()，
 notify()，wait()方法时抛出该异常。
 */