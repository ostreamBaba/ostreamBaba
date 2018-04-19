package com.annotation;

import com.annotation.action.UserAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Create by ostreamBaba on 18-4-3
 * @描述
 */
public class AnnotationAssembleTest {

    @Test
    public void test(){
        //定义配置文件的路径
        String xmlPath="/config/test.xml";
        //初始化spring容器,加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        UserAction userAction=(UserAction) applicationContext.getBean("userAction");
        userAction.save();
    }
}
