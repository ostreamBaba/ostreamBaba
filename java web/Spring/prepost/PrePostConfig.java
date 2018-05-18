package com.viscu.spring.prepost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ Create by ostreamBaba on 18-5-18
 * @ Bean的初始化和销毁
 */

class BeanWayService{
    public void init(){
        System.out.println("@Bean-init-method");
    }
    public BeanWayService() {
        System.out.println("初始化构造函数"+this.getClass().getSimpleName());
    }
    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }
}

class JSR250WayService{
    @PostConstruct
    public void init(){
        System.out.println("@jsr250-init-method");
    }
    public JSR250WayService() {
        System.out.println("初始化构造函数"+this.getClass().getSimpleName());
    }
    @PreDestroy
    public void destroy(){
        System.out.println("@jsr250-destroy-method");
    }
}

@Configuration
@ComponentScan("com.viscu.spring.prepost")
public class PrePostConfig {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public BeanWayService beanWayService(){
        return new BeanWayService();
    }
    @Bean
    public JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }
}

class PrePostMain{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(PrePostConfig.class);
        BeanWayService beanWayService=applicationContext.getBean(BeanWayService.class);
        JSR250WayService jsr250WayService=applicationContext.getBean(JSR250WayService.class);
        applicationContext.close();
    }
}
