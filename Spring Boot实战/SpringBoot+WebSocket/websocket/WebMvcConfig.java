package com.viscu.springboot;

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
        registry.addViewController( "/ws" ).setViewName( "/ws" );
        registry.addViewController( "/wsk" ).setViewName( "/webSocket" );
    }
}

