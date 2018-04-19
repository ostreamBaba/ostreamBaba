package com.ostream.springmvc4;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * @Create by ostreamBaba on 18-4-9
 * @描述
 */
public class    WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();//提供servlet3.0+配置接口
        context.register(MyMvcConfig.class);
        context.setServletContext(servletContext);
        Dynamic servlet=servletContext.addServlet("dispatcher",new DispatcherServlet(context));//注册springmvc的dispatcherServlet
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        servlet.setAsyncSupported(true);//开启异步方法支持
    }
}
