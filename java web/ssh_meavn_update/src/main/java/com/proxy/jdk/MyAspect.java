package com.proxy.jdk;

/**
 * @Create by ostreamBaba on 18-4-4
 * @描述
 */

//jdk代理
public class MyAspect {
    public void before(){
        System.out.println("before");
    }
    public void after(){
        System.out.println("after");
    }
}
