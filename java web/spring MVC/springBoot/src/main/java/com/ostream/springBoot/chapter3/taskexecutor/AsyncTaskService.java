package com.ostream.springBoot.chapter3.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Create by ostreamBaba on 18-4-9
 * @描述
 */
@Service
public class AsyncTaskService {

    @Async  //表明该方法是异步方法
    public void executeAsyncTask(int i){
        System.out.println("执行异步任务： "+i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1： "+(i+1));
    }

}
