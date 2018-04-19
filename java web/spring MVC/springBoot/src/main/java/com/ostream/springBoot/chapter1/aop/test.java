package com.ostream.springBoot.chapter1.aop;

import com.ostream.springBoot.chapter1.aop.scope.DemoPrototypeService;
import com.ostream.springBoot.chapter1.aop.scope.DemoSingletonService;
import com.ostream.springBoot.chapter1.aop.service.DemoAnnotationService;
import com.ostream.springBoot.chapter1.aop.service.DemoMethodService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */
public class test {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AopConfig.class);
        DemoMethodService demoMethodService=(DemoMethodService)context.getBean(DemoMethodService.class);
        DemoAnnotationService demoAnnotationService=(DemoAnnotationService)context.getBean(DemoAnnotationService.class);
        demoAnnotationService.add();
        demoMethodService.add();
        context.close();
    }

    @Test
    public void testScope(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ScopeConfig.class);
        DemoSingletonService demoSingletonService1=(DemoSingletonService)context.getBean(DemoSingletonService.class);
        DemoSingletonService demoSingletonService2=(DemoSingletonService)context.getBean(DemoSingletonService.class);

        DemoPrototypeService demoPrototypeService1=(DemoPrototypeService)context.getBean(DemoPrototypeService.class);
        DemoPrototypeService demoPrototypeService2=(DemoPrototypeService)context.getBean(DemoPrototypeService.class);

        System.out.println(demoPrototypeService1==demoPrototypeService2);
        System.out.println(demoSingletonService1==demoSingletonService2);




    }


}
