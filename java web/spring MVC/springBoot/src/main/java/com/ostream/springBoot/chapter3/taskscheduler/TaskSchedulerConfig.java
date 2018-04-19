package com.ostream.springBoot.chapter3.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Create by ostreamBaba on 18-4-9
 * @描述
 */

@Configuration
@ComponentScan("com.ostream.springBoot.chapter3.taskscheduler")
@EnableScheduling  //开启对计划任务的支持
public class TaskSchedulerConfig {
}
