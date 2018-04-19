package com.ostream.springBoot.chapter1.aop.service;

import com.ostream.springBoot.chapter1.aop.Action;
import org.springframework.stereotype.Service;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */

@Service
public class DemoAnnotationService {
    @Action(name = "注解action")
    public void add(){}
}
