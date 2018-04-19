package com.ostream.springBoot.chapter3;

import com.ostream.springBoot.chapter3.annotation.DemoConfig;
import com.ostream.springBoot.chapter3.annotation.DemoService;
import com.ostream.springBoot.chapter3.aware.AwareConfig;
import com.ostream.springBoot.chapter3.aware.AwareService;
import com.ostream.springBoot.chapter3.conditional.ConditionConfig;
import com.ostream.springBoot.chapter3.conditional.ListService;
import com.ostream.springBoot.chapter3.taskexecutor.AsyncTaskService;
import com.ostream.springBoot.chapter3.taskexecutor.TaskExecutorConfig;
import com.ostream.springBoot.chapter3.taskscheduler.ScheduledTaskService;
import com.ostream.springBoot.chapter3.taskscheduler.TaskSchedulerConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Create by ostreamBaba on 18-4-9
 * @描述
 */
public class test {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext( AwareConfig.class);
        AwareService awareService=context.getBean(AwareService.class);
        awareService.outputResult();
    }

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext( TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService=(AsyncTaskService)context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();
    }

    //计划任务test不了
    /*@Test
    public void test2(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext( TaskSchedulerConfig.class);
    }*/

    @Test
    public void test2(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext( ConditionConfig.class);
        ListService listService=context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name")+":"+listService.showListCmd());
    }

    @Test
    public void test3(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext( DemoConfig.class);
        DemoService demoService=context.getBean(DemoService.class);
        demoService.outputResult();
    }

}
