package com.ioc;

import com.ioc.dao.UserDao;
import com.ioc.dao.bean1;
import com.ioc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Create by ostreamBaba on 18-4-3
 * @描述
 */
public class testApp {

    @Test
    public void demo01(){
        //定义配置文件的路径
        String xmlPath="/config/applicationContext.xml";
        //初始化spring容器,加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        //获取UserDao接口实现类
        UserDao userDao=(UserDao)applicationContext.getBean("userDao2");
        userDao.save();
    }

    @Test
    public void demo02(){
        //定义配置文件的路径
        String xmlPath="/config/applicationContext.xml";
        //初始化spring容器,加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        //获取UserDao接口实现类
        UserService userService=(UserService)applicationContext.getBean("userService");
        userService.addUser();
    }

    //构造器实例化
    @Test
    public void demo03(){
        //定义配置文件的路径
        String xmlPath="/config/applicationContext.xml";
        //初始化spring容器,加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        //获取UserDao接口实现类
        System.out.println(applicationContext.getBean("bean1"));
        System.out.println(applicationContext.getBean("bean1"));
    }

    //静态方法实例化
    @Test
    public void demo04(){
        //定义配置文件的路径
        String xmlPath="/config/applicationContext.xml";
        //初始化spring容器,加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        //获取UserDao接口实现类
        System.out.println(applicationContext.getBean("bean2"));
    }

    //实例工厂方式实例化
    @Test
    public void demo05(){
        //定义配置文件的路径
        String xmlPath="/config/applicationContext.xml";
        //初始化spring容器,加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        //获取UserDao接口实现类
        System.out.println(applicationContext.getBean("bean3"));
    }

    @Test
    public void demo06(){
        //定义配置文件的路径
        String xmlPath="/config/applicationContext.xml";
        //初始化spring容器,加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        //获取UserDao接口实现类
        System.out.println(applicationContext.getBean("bean5"));
        System.out.println(applicationContext.getBean("bean5"));
    }

    @Test
    public void demo07(){
        //定义配置文件的路径
        String xmlPath="/config/applicationContext.xml";
        //初始化spring容器,加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        //获取UserDao接口实现类
        System.out.println(applicationContext.getBean("user1").toString());
        System.out.println(applicationContext.getBean("user2").toString());
    }

}
