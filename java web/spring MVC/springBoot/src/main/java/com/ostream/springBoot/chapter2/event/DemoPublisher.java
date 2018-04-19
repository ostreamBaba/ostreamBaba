package com.ostream.springBoot.chapter2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */
//注入ApplicationContext来发布事件
@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext context;

    public void publish(String msg){
        context.publishEvent(new DemoEvent(this,msg));
    }
}
