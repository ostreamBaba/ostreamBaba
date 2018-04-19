package com.ostream.springBoot.chapter2.prepost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */

@Configuration
@ComponentScan("com.ostream.springBoot.chapter2.prepost")
public class PrepostConfig {

    //Bean的初始化和销毁
    @Bean(initMethod = "init",destroyMethod = "destroy")
    BeanWayService beanWayService(){
        return new BeanWayService();
    }
    @Bean
    JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }

}
