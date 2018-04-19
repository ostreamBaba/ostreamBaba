package com.aspect.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Create by ostreamBaba on 18-4-5
 * @描述
 */


@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.aspect.dao..*.*(..))")
    private void pointCut(){}

    /*前置通知*/
    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知，目标：");
        System.out.println(joinPoint.getTarget()+",方法名称：");
        System.out.println(joinPoint.getSignature().getName());
    }

    /*后置通知*/
    @AfterReturning(value = "pointCut()", returning="returnVal")
    public void afterReturning(JoinPoint joinPoint,Object returnVal){
        System.out.println("后置通知，方法名称："+joinPoint.getSignature().getName());
    }

    /*环绕通知*/
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        System.out.println("环绕开始：");
        Object obj=proceedingJoinPoint.proceed();
        System.out.println("环绕结束");
        return obj;
    }

    /*异常通知*/
    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Throwable e){
        System.out.println("异常通知： 出错了"+e.getMessage());
    }

    /*最终通知*/
    @After("pointCut()")
    public void after(){
        System.out.println("最终通知");
    }
}
