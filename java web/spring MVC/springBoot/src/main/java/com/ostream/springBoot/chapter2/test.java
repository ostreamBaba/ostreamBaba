package com.ostream.springBoot.chapter2;

import com.ostream.springBoot.chapter3.aware.AwareConfig;
import com.ostream.springBoot.chapter3.aware.AwareService;
import com.ostream.springBoot.chapter2.el.ElConfig;
import com.ostream.springBoot.chapter2.event.DemoPublisher;
import com.ostream.springBoot.chapter2.event.EventConfig;
import com.ostream.springBoot.chapter2.prepost.BeanWayService;
import com.ostream.springBoot.chapter2.prepost.JSR250WayService;
import com.ostream.springBoot.chapter2.prepost.PrepostConfig;
import com.ostream.springBoot.chapter2.profile.DemoBean;
import com.ostream.springBoot.chapter2.profile.ProfileConfig;
import com.ostream.springBoot.chapter3.taskexecutor.AsyncTaskService;
import com.ostream.springBoot.chapter3.taskexecutor.TaskExecutorConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */
public class test {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext( ElConfig.class);
        ElConfig elConfig=(ElConfig)context.getBean(ElConfig.class);
        elConfig.outputResource();
        context.close();
    }

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext( PrepostConfig.class);

        BeanWayService beanWayService=(BeanWayService)context.getBean(BeanWayService.class);
        JSR250WayService jsr250WayService=(JSR250WayService)context.getBean(JSR250WayService.class);
        context.close();

    }

    @Test
    public void test2(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register( ProfileConfig.class); //注册配置类
        context.refresh();//刷新容器

        DemoBean demoBean=(DemoBean)context.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        context.close();
    }

    @Test
    public void test3(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext( EventConfig.class);
        DemoPublisher demoPublisher=(DemoPublisher) context.getBean("demoPublisher");
        demoPublisher.publish("event yo!!!!");
        context.close();
    }

}
