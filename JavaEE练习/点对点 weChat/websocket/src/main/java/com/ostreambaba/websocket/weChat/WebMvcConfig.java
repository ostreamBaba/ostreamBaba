package com.ostreambaba.websocket.weChat;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ Create by ostreamBaba on 18-5-22
 * @ 描述
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController( "/ws" ).setViewName( "/webSocket" );
        registry.addViewController("login").setViewName("/login");
        registry.addViewController("/chat").setViewName("/chat");
        registry.addViewController("angular").setViewName("/AngularJS");
    }
}

