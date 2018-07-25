package com.netty;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @ Create by ostreamBaba on 18-7-25
 * @ √Ë ˆ
 */


@Component
public class InitNetty implements ApplicationListener<ContextRefreshedEvent>{
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new NettyThread().start();
    }
}
