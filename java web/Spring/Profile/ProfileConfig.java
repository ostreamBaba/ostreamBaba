package com.viscu.spring.Profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

/**
 * @ Create by ostreamBaba on 18-5-18
 * @ profile为不同环境使用不同配置提供了支持
 */

class DemoBean{
    private String content;
    public DemoBean(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}

@ComponentScan("com.viscu.spring.Profile")
public class ProfileConfig {
    @Bean
    @Profile("dev")
    public DemoBean devDemoBean(){
        return new DemoBean("from development profile");
    }
    @Bean
    @Profile("prod")
    public DemoBean prodDemoBean(){
        return new DemoBean("from production profile");
    }
}

class profileMain{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("prod");
        applicationContext.register(ProfileConfig.class);
        applicationContext.refresh();

        DemoBean demoBean=applicationContext.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        applicationContext.close();
    }
}
