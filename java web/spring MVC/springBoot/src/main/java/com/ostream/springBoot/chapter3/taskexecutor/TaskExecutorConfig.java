package com.ostream.springBoot.chapter3.taskexecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Create by ostreamBaba on 18-4-9
 * @描述
 */



@Configuration
@ComponentScan("com.ostream.springBoot.chapter3.taskexecutor")
@EnableAsync  //开启异步支持
public class TaskExecutorConfig implements AsyncConfigurer{

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);//线程池维护线程的最少数量
        taskExecutor.setMaxPoolSize(10); //线程池维护线程的最大数量
        taskExecutor.setQueueCapacity(25); //线程池所使用的缓冲队列
        taskExecutor.initialize();
        return  taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
