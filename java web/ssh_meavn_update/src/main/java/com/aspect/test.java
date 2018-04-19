package com.aspect;

import com.aspect.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Create by ostreamBaba on 18-4-5
 * @描述
 */

public class test {

    @Test
    public void test(){
        String xmlPath="/config/aspectj.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        UserDao userDao=(UserDao)applicationContext.getBean("userDao");
        userDao.save();
    }

}
