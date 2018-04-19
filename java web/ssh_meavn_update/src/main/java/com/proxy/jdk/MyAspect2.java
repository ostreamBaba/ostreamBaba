package com.proxy.jdk;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @Create by ostreamBaba on 18-4-4
 * @描述
 */
public class MyAspect2 implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object obj=methodInvocation.proceed();
        after();
        return obj;
    }

    private void before(){
        System.out.println("before");
    }

    private void after(){
        System.out.println("after");
    }
}
