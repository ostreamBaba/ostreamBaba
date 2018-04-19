package com.ostream.springBoot.chapter2.profile;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletException;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */

//设置配置环境
public class WebInit implements WebApplicationInitializer{

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("spring.profiles.default","dev");
    }
}
