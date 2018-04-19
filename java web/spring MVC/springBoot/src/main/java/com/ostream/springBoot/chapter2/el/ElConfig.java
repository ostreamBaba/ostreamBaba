package com.ostream.springBoot.chapter2.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;


/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */

@Configuration
@ComponentScan("com.ostream.springBoot.chapter2")
@PropertySource("classpath:com/ostream/springBoot/chapter2/el/test.properties")
public class ElConfig {

    @Value("I love u")
    private String normal;
    @Value("#{systemProperties['os.name']}")
    private String osName;
    @Value("#{ T(java.lang.Math).random()*100.0}")
    private double randomNumber;
    @Value("#{demoService.another}")  //注入其他bean
    private String fromAnother;
    @Value("http://www.baidu.com")
    private Resource testUrl;
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    //注入配置文件 若使用@Value注入 需要配置一个PropertySourcesPlaceholderConfigurer的bean
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
