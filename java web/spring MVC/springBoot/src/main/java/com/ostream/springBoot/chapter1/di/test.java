package com.ostream.springBoot.chapter1.di;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */
public class test {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DiConfig.class);
        UseFuntionService useFuntionService=(UseFuntionService) context.getBean("useFuntionService");
        System.out.println(useFuntionService.say("lil pump"));
        context.close();

    }

    

}
