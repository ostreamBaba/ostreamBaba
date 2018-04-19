package com.ssh;

import com.ssh.entity.User;
import com.ssh.service.UserService;
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
    private static final UserService USER_SERVICE;
    private static final UserService USER_SERVICEI;

    static {
        XMLPATH="/config/ssh.xml";
        APPLICATION_CONTEXT=new ClassPathXmlApplicationContext(XMLPATH);
        USER_SERVICE= (UserService)APPLICATION_CONTEXT.getBean("userService");
        USER_SERVICEI=(UserService)APPLICATION_CONTEXT.getBean("userServiceI");
    }

    //spring 整合hibernate 使用hibernate.cfg.xml
    @Test
    public void test(){
        User user=new User();
        user.setUsername("lil Yatchy");
        user.setPassword("66");
        USER_SERVICE.saveUser(user);
    }

    @Test
    public void test1(){
        User user=new User();
        user.setUsername("jackie");
        user.setPassword("1");
        USER_SERVICEI.saveUser(user);
    }


    @Test
    public void test3(){

    }
}
