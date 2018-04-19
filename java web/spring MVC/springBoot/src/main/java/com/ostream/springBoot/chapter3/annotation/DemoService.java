package com.ostream.springBoot.chapter3.annotation;

import org.springframework.stereotype.Service;

/**
 * @Create by ostreamBaba on 18-4-9
 * @描述
 */

@Service
public class DemoService {

    public void outputResult(){
        System.out.println("组合注解获得bean");
    }
}
