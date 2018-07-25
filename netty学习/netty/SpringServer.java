package com.netty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ Create by ostreamBaba on 18-7-25
 * @ 描述
 */

@Configuration
@ComponentScan("com.netty")
public class SpringServer {
    public static void main(String[] args) throws InterruptedException {
        //构建spring容器
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringServer.class);
        context.start();

        //主线程挂在这里
        synchronized (SpringServer.class){
            SpringServer.class.wait();
        }
    }
}
