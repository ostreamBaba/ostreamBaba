package com.ostream.springBoot.chapter3.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Create by ostreamBaba on 18-4-9
 * @描述
 */
public class test {

    //并发执行
    public static void main(String[] args) {
        /*AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);*/
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext( TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService=(AsyncTaskService)context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();
    }
}
