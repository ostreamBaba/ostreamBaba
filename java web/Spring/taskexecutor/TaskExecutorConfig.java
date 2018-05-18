package com.viscu.spring.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ Create by ostreamBaba on 18-5-19
 * @ 描述
 */

@Configuration
@ComponentScan("com.viscu.spring.taskexecutor")
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer{
    //获得一个基于线程池的taskexecutor
    public Executor getAsyncExecutor() {
        //对线程池进行设置
        ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);//核心线程数
        taskExecutor.setMaxPoolSize(10);//最大线程数
        taskExecutor.setQueueCapacity(25);//缓冲任务队列的长度
        taskExecutor.initialize();
        return taskExecutor;
    }
}
//任务执行类
@Service
class AsyncTaskService{
    @Async //异步任务
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务：" +i);
    }
    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1：" +(i+1));
    }
}
class Main{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService=applicationContext.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
    }
}
/*
corePoolSize：线程池维护线程的最少数量
keepAliveSeconds：允许的空闲时间
maxPoolSize：线程池维护线程的最大数量
queueCapacity：缓存队列
rejectedExecutionHandler：对拒绝task的处理策略
如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。
如果此时线程池中的数量等于corePoolSize，但是缓冲队列workQueue未满，那么任务被放入缓冲队列。
如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maxPoolSize，建新的线程来处理被添加的任务。
如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maxPoolSize，那么通过handler所指定的策略来处理此任务。
也就是：处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、最大线程maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
当线程池中的线程数量大于corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。
*/
