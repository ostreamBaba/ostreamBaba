package com.ostream.ThinkingInJavaII.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Create by ostreamBaba on 18-4-28
 * @描述
 */
//Executor


public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec= Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();//防止新任务被提交给这个Executor
    }
}


class FixedThreadPool{
    public static void main(String[] args) {
        ExecutorService exec=Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
        /*ExecutorService exec1=Executors.newFixedThreadPool(4);
        for (int i = 0; i < 5; i++) {
            exec1.execute(new LiftOff());
        }
        exec1.shutdown();*/
    }
}

//  SingleThreadExecutor会序列化所有提交给它的任务 并会维护它自己的悬挂任务队列
class SingleThreadPool{
    public static void main(String[] args) {
        ExecutorService exec=Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}