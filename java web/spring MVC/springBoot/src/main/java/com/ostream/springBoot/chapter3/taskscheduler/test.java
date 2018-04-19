package com.ostream.springBoot.chapter3.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Create by ostreamBaba on 18-4-9
 * @描述
 */
public class test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    }

}
