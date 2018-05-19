package com.viscu.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ Create by ostreamBaba on 18-5-19
 * @ √Ë ˆ
 */
@Configuration
public class TestConfig{
    @Bean
    @Profile("dev")
    public TestBean devTestBean(){
        return new TestBean("dev");
    }
    @Bean
    @Profile("prod")
    public TestBean prodTestBean(){
        return new TestBean("prod");
    }
}
