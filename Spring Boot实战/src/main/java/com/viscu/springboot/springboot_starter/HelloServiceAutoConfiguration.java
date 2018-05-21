package com.viscu.springboot.springboot_starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ Create by ostreamBaba on 18-5-21
 * @ 自动配置类(若想要自动配置类生效 就要注册自动配置类)
 */

@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class)
@ConditionalOnClass(HelloService.class) //判断HelloService.class这个类是否在类路径存在
//当设置hello=enabled的情况下,如果没有设置则默认为true,即条件符合
@ConditionalOnProperty(prefix = "hello", value = "enabled", matchIfMissing = true)
public class HelloServiceAutoConfiguration {
    @Autowired
    private HelloServiceProperties helloServletProperties;

    @Bean
    @ConditionalOnMissingBean(HelloService.class)//当容器中没有这个类的情况下 自动配置这个Bean
    public HelloService helloService(){
        HelloService helloService=new HelloService();
        helloService.setMsg(helloServletProperties.getMsg());
        return helloService;
    }
}
