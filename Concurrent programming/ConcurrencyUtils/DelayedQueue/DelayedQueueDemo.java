package com.viscu.concurrency.DelayedQueue;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @ Create by ostreamBaba on 18-10-26
 * @ 延迟队列
 */

public class DelayedQueueDemo {

    //需要实现Delayed接口
    static class Event implements Delayed{

        private Date startDate;

        public Event(Date startDate) {
            this.startDate = startDate;
        }

        @Override
        public long getDelay(TimeUnit timeUnit) {
            Date now=new Date();
            long diff=startDate.getTime()-now.getTime();
            return timeUnit.convert(diff,TimeUnit.NANOSECONDS);
        }

        // 避免溢出
        @Override
        public int compareTo(Delayed delayed) {
            long res=this.getDelay(TimeUnit.NANOSECONDS)-delayed.getDelay(TimeUnit.NANOSECONDS);
            if(res<0){
                return -1;
            }else if(res>0){
                return 1;
            }else{
                return 0;
            }
        }
    }

    static class Task implements Runnable{
        private int id;
        private DelayQueue<Event> queue;

        public Task(int id, DelayQueue<Event> queue) {
            this.id = id;
            this.queue = queue;
        }

        @Override
        public void run() {
            Date now=new Date();
            Date delay=new Date();
            delay.setTime(now.getTime()+id*1000);
            System.out.printf("Thread %s: %s\n",id,delay);
            for (int i = 0; i < 100; i++) {
                Event event=new Event(delay);
                queue.add(event);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Event> queue=new DelayQueue<>();
        /*Executor executor= Executors.newFixedThreadPool(5);*/
        Thread[] threads=new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            /*executor.execute(new Task(i+1,queue));*/
            threads[i]=new Thread(new Task(i+1,queue));
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        do{
            int counter=0;
            Event event;
            do{
                event=queue.poll();
                if(event!=null){
                    ++counter;
                }
            }while (event!=null);
            System.out.printf("At %s you have read %d events\n",new Date(),counter);
            TimeUnit.MILLISECONDS.sleep(500);
        }while (queue.size()>0);
    }


}
