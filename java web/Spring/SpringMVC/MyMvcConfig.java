package com.viscu.springmvc;

import com.viscu.springmvc.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @ Create by ostreamBaba on 18-5-19
 * @ Spring MVC的定制配置需要我们的配置了继承WebMvcConfigurerAdapter类
 */


@Configuration
@EnableWebMvc //开启对Spring MVC的支持
@ComponentScan("com.viscu.springmvc")
public class MyMvcConfig extends WebMvcConfigurerAdapter{
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //添加静态资源 addResourceHandler对外暴露访问路径 addResourceLocations指的是文件放置的路径
        registry.addResourceHandler("/assets/").addResourceLocations("classpath:/assets/");
    }
    //配置拦截器的bean 业务含义为计算每一次请求的处理时间
    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }
    //注册该拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }
    //实现页面的跳转 没什么业务服务
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("index").setViewName("index");
        registry.addViewController("toUpload").setViewName("upload");
    }

    //若路径参数到.的话.后面的参数会被忽略 /pathvar/xx.yy  anno/pathvar/xx.yy
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false); //不可忽略.后面的参数
    }
    //文件上传
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
        multipartResolver.setMaxInMemorySize(1000000);
        multipartResolver.setDefaultEncoding("utf-8");//设置文件默认编码
        return multipartResolver;
    }

}
