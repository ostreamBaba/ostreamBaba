package com.ostream.springBoot.chapter2.prepost;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */


public class BeanWayService {

    public void init(){
        System.out.println("@Bean-init-method");
    }

    public BeanWayService() {
        super();
        System.out.println("初始化构造函数--beanWayService");
    }

    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }

}
