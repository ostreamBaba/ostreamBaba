package com.ostream.springBoot.chapter1.aop.aspectj;

import com.ostream.springBoot.chapter1.aop.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */


@Aspect
@Component
public class MyAspectj {

    @Pointcut("@annotation(com.ostream.springBoot.chapter1.aop.Action)")
    public void annotationPointCut(){}

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature methodSignature=(MethodSignature)joinPoint.getSignature();
        Method method=methodSignature.getMethod();
        Action action=method.getAnnotation(Action.class);
        System.out.println("注解式拦截："+action.name());
    }

    @Before("execution(* com.ostream.springBoot.chapter1.aop.service.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature=(MethodSignature)joinPoint.getSignature();
        Method method=methodSignature.getMethod();
        System.out.println("方法规则式拦截："+method.getName());
    }
}
