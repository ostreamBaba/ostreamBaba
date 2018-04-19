package com.ssh_annotation;

import com.ssh.entity.User;
import com.ssh.service.UserService;
import com.ssh_annotation.action.UserAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Create by ostreamBaba on 18-4-6
 * @描述
 */


public class test {

    private static final String XMLPATH;
    private static final ApplicationContext APPLICATION_CONTEXT;

    static {
        XMLPATH="/config/ssh_annotation.xml";
        APPLICATION_CONTEXT=new ClassPathXmlApplicationContext(XMLPATH);
    }

    //spring 整合hibernate 使用hibernate.cfg.xml
    @Test
    public void test(){
        UserAction userAction=new UserAction();
        userAction.getModel();
    }


}