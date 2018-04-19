package com.proxy.jdk;

import com.proxy.dao.UserDao;
import com.proxy.dao.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Create by ostreamBaba on 18-4-4
 * @描述
 */

//jdk动态代理 proxy
public class MyBeanFactory {

    public static UserDao getBean(){
        final UserDao userDao=new UserDaoImpl();

        final MyAspect myAspect=new MyAspect();

        return (UserDao) Proxy.newProxyInstance(
                MyBeanFactory.class.getClassLoader(),
                new Class[]{UserDao.class},
                new InvocationHandler(){
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        myAspect.before();
                        Object obj=method.invoke(userDao,objects);
                        myAspect.after();
                        return obj;
                    }
                }
        );
    }

}
