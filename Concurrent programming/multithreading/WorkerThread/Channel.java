package com.multithreading.WorkerThread;

/**
 * @ Create by ostreamBaba on 18-6-13
 * @ 负责传递工作的请求以及保存工人线程的类
 */
public class Channel {

    private static final int MAX_REQUEST=100;
    private final Request[] requestQueue;
    private int tail; //下次putRequest的位置
    private int head; //下次takeRequest的位置
    private int count; //Request的数量

    private final WorkerThread[] threadPool;

    public Channel(int threads) {
        this.requestQueue=new Request[MAX_REQUEST];
        tail=0;
        head=0;
        count=0;
        threadPool=new WorkerThread[threads];
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i]=new WorkerThread("Worker-"+i,this);
        }
    }
    public void startWorkers(){
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i].start();
        }
    }

    public synchronized void putRequest(Request request){
        while (count>=requestQueue.length){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requestQueue[tail]=request;
        tail=(tail+1)%MAX_REQUEST;
        ++count;
        notifyAll();
    }

    public synchronized Request takeRequest(){
        while (count<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request=requestQueue[head];
        head=(head+1)%MAX_REQUEST;
        --count;
        notifyAll();
        return request;
    }



}
