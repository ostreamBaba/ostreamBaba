package com.viscu.spring.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * @ Create by ostreamBaba on 18-5-18
 * @ AOP
 */

@Service
public class DemoAnnotationService {
    @Action(name="注解式拦截的add方法")
    public void add(){
        System.out.println("DAS");
    }
}

@Service
class DemoMethodService{
    public void add(){
        System.out.println("DMS");
    }
}

@Aspect
@Component
class LogAspect{
    //声明切入点
    @Pointcut("@annotation(com.viscu.spring.AOP.Action)")
    public void annotationPointCut(){}


    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature=(MethodSignature)joinPoint.getSignature();
        Method method=signature.getMethod();
        Action action=method.getAnnotation(Action.class);
        System.out.println("注解式拦截"+action.name());
    }

    //直接使用了拦截规则作为参数
    //JoinPoint表示连接点
    @Before("execution(* com.viscu.spring.AOP.DemoMethodService.*(..))")
    public void before(JoinPoint joinpoint){
        MethodSignature signature=(MethodSignature)joinpoint.getSignature();
        Method method=signature.getMethod();
        System.out.println("方法式拦截"+method.getName());
    }
}

@Configuration
@ComponentScan("com.viscu.spring.AOP") //扫描包
@EnableAspectJAutoProxy //开启spring对Aspctj的支持
class AopConfig{
}

class AspctjMain{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(AopConfig.class);
        DemoMethodService methodService=applicationContext.getBean(DemoMethodService.class);
        DemoAnnotationService annotationService=applicationContext.getBean(DemoAnnotationService.class);
        methodService.add();
        annotationService.add();
        applicationContext.close();
    }
}
