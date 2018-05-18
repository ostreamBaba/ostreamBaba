package com.viscu.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ Create by ostreamBaba on 18-5-18
 * @ 描述
 */

//自定义的事件
class DemoEvent extends ApplicationEvent{
    //private static final long serialVersionUID = 1L;
    private String massage;
    public DemoEvent(Object source,String massage) {
        super( source );
        this.massage=massage;
    }
    public String getMassage() {
        return massage;
    }
    public void setMassage(String massage) {
        this.massage = massage;
    }
}
//事件的监听器
//制定监听的事件类型
@Component
class DemoListener implements ApplicationListener<DemoEvent>{
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg=demoEvent.getMassage();
        System.out.println("接受到信息："+msg);
    }
}
@Component
class DemoPublisher{
    @Autowired
    ApplicationContext applicationContext; //注入ApplicationContext来发布事件
    public void publish(String msg){
        applicationContext.publishEvent(new DemoEvent(this,msg));
    }
}

@Component
class DemoPublisherII{
    @Autowired
    ApplicationContext applicationContext; //注入ApplicationContext来发布事件
    public void publish(String msg){
        applicationContext.publishEvent(new DemoEvent(this,msg));
    }
}

@Configuration
@ComponentScan("com.viscu.spring.event")
public class EventConfig {
}

class EventMain{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher demoPublisher=applicationContext.getBean(DemoPublisher.class);
        DemoPublisherII demoPublisherII=applicationContext.getBean(DemoPublisherII.class);
        demoPublisher.publish("he's fuckin' dope");
        demoPublisherII.publish("he's fuckin' pretty");
        applicationContext.close();
    }
}

