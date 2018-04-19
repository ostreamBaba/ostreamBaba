package com.ostream.springBoot.chapter2.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */
public class JSR250WayService {

    @PostConstruct
    public void init(){
        System.out.println("jsr25-init-method");
    }

    public JSR250WayService() {
        super();
        System.out.println("初始化构造函数--jsr250WayService");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("jsr250-destory-method");
    }
}
