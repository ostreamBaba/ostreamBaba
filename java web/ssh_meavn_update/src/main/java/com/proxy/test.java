package com.proxy;

import com.ostreamBaba.entity.User;
import com.proxy.dao.BookDao;
import com.proxy.dao.UserDao;
import com.proxy.jdk.MyBeanFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Create by ostreamBaba on 18-4-4
 * @描述
 */
public class test {

    @Test
    public void test1(){
        //从工厂获得指定内容
        UserDao userDao= MyBeanFactory.getBean();
        userDao.save();
        userDao.delete();
        userDao.find();
        userDao.update();
        System.out.println("bookDao");
        BookDao bookDao= com.proxy.cglib.MyBeanFactory.getBean();
        bookDao.save();
        bookDao.delete();
        bookDao.find();
        bookDao.update();
    }

    @Test
    public void test2(){
        String xmlPath="/config/reflect.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        UserDao userDao=(UserDao)applicationContext.getBean("userDaoProxy");
        userDao.save();
    }
}
