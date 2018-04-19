package com.ostream.springBoot.chapter2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */

//定义事件监听器
@Component
public class DemoListener implements ApplicationListener<DemoEvent>{

    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg=demoEvent.getMsg();
        System.out.println("接受到消息："+msg);
    }
}
