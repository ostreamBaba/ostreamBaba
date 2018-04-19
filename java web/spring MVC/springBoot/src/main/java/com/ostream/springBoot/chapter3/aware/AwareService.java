package com.ostream.springBoot.chapter3.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */

//让bean获得spring内部的服务
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{

    private String beanName;
    private ResourceLoader loader;

    @Override
    public void setBeanName(String name) {
        this.beanName=name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader=resourceLoader;
    }

    public void outputResult(){
        System.out.println("bean的名称: "+beanName);
        Resource resource=loader.getResource("classpath:com/ostream/springBoot/chapter2/aware/test.txt");
        try{
            System.out.println("加载的文件内容: "+ IOUtils.toString(resource.getInputStream()));

        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
