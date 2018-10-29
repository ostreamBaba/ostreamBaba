package com.viscu.concurrency.DelayedQueue.demo1;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @ Create by ostreamBaba on 18-10-26
 * @ 延时调度任务
 */

public class Task<T extends Runnable> implements Delayed {

    private final long time;//延迟的时间

    private final T task;//执行的任务

    public Task(long time, T task) {
        this.time = System.nanoTime()+time;
        //System.out.println(this.time);
        this.task = task;
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(this.time-System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed delayed) {
        if(delayed==this){
            return 0;
        }
        if(delayed instanceof Task){
            Task task= (Task)delayed;
            long result=this.time-task.time;
            if(result<0){
                return -1;
            }else if(result>0){
                return 1;
            }else{
                return 0;
            }
        }
        long d=(this.getDelay(TimeUnit.NANOSECONDS)-delayed.getDelay(TimeUnit.NANOSECONDS));
        return d==0?0:(d>0?1:-1);
    }

    public T getTask() {
        return task;
    }

    @Override
    public int hashCode() {
        return task.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Task){
            return o.hashCode()==this.hashCode();
        }
        return false;
    }
}
