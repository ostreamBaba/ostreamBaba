package com.proxy.cglib;

import com.proxy.dao.BookDao;
import com.proxy.jdk.MyAspect;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Create by ostreamBaba on 18-4-4
 * @描述
 */
public class MyBeanFactory {


    public static BookDao getBean(){
        final BookDao bookDao=new BookDao();
        final MyAspect myAspect=new MyAspect();
        //生成代理类 生成指定对象子类 增强类
        //核心类
        Enhancer enhancer=new Enhancer();
        //添加需要增强的类
        enhancer.setSuperclass(bookDao.getClass());
        //添加回调函数
        enhancer.setCallback( new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                myAspect.before();
                Object obj=method.invoke(bookDao,objects);
                myAspect.after();
                return obj;
            }
        } );
        //创建代理类
        BookDao bookDaoProxy=(BookDao)enhancer.create();
        return bookDaoProxy;
    }



}
