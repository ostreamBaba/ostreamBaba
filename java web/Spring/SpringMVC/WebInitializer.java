package com.viscu.springmvc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @ Create by ostreamBaba on 18-5-19
 * @ Web配置
 */
public class WebInitializer implements WebApplicationInitializer{
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
        ctx.register(MyMvcConfig.class);
        ctx.setServletContext(servletContext);

        //注册Spring MVC的DispatcherServlet
        //Spring主要也是通过DispatcherServlet实现了Servlet这个接口，又叫前端控制器，
        //来自前端的请求会先到达这里，它负责到后台去匹配合适的handler。DispatcherServlet的主要工作流程如下：
        //前端请求到达DispatcherServlet。
        //前端控制器请求HandlerMappering 找Handler。
        //如果查找到存在的处理器，进一步去调用service和dao层
        //返回结果再到controller层，渲染具体的视图，返回结果给页面。
        ServletRegistration.Dynamic servlet=servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
