package com.viscu.spring.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Create by ostreamBaba on 18-5-19
 * @ 描述
 */

@Configuration
@ComponentScan("com.viscu.spring.taskscheduler")
@EnableScheduling //开启对计划任务的支持
public class ScheduledTaskConfig {
}

@Service
class ScheduledTaskService{
    private static final SimpleDateFormat DATE_FORMAT;
    static {
        DATE_FORMAT=new SimpleDateFormat("HH:mm:ss");
    }

    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔五秒执行一次："+DATE_FORMAT.format(new Date()));
    }
    @Scheduled(cron = "0 09 02 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间："+DATE_FORMAT.format(new Date())+" 执行");
    }
}
class Main{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(ScheduledTaskConfig.class);
        ScheduledTaskService scheduledTaskService=applicationContext.getBean(ScheduledTaskService.class);
    }
}