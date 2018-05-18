package com.viscu.spring.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @ Create by ostreamBaba on 18-5-18
 * @ Spring aware目的为了让bean获得Spring容器的服务
 */

// BeanNameAware 获得到当前容器Bean的名字
// ResourceLoaderAware 获得资源加载器

@Service
class AwareService implements BeanNameAware,ResourceLoaderAware{
    private String beanName;
    private ResourceLoader resourceLoader;
    public void setBeanName(String beanName) {
        this.beanName=beanName;
    }
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader=resourceLoader;
    }
    public void outputResult(){
        System.out.println("Bean的名称:"+beanName);
        Resource resource=resourceLoader.getResource("classpath:com/viscu/spring/aware/test.txt");
        try{
            System.out.println("资源加载器加载的内容是："+ IOUtils.toString(resource.getInputStream()));
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

@Configuration
@ComponentScan("com.viscu.spring.aware")
public class AwareConfig {
}

class Main{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService=applicationContext.getBean(AwareService.class);
        awareService.outputResult();
        applicationContext.close();
        System.out.println(awareService.getClass().getSimpleName());
    }
}

