package com.viscu.ssh.test;


import com.viscu.entity.Customer;
import com.viscu.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @Create by ostreamBaba on 18-3-31
 * @描述
 */
public class CustomerTest{


    @Test
    public void insertTest2(){
        Session session= HibernateUtils.getSession();
        session.beginTransaction();
        Customer customer=new Customer(); //瞬时态
        customer.setName("viscu");
        customer.setAge(20);
        customer.setCity("huilai");
        customer.setSex("boy");
        session.save(customer); //持久态
        session.getTransaction().commit();
        session.close();
        System.out.println(customer );//脱管态
    }

    //一级缓存
    @Test
    public void insertTest3(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();
        Customer c1=(Customer)session.get(Customer.class,2);
        System.out.println(c1);
        Customer c2=(Customer)session.get(Customer.class,2);
        System.out.println(c2);
        session.getTransaction().commit();
        session.close();
    }


    //hibernate快照
    @Test
    public void insertTest4(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();
        Customer customer=new Customer();
        customer.setName("ostream");
        customer.setAge(21);
        session.save(customer);
        customer.setName("viscu");
        session.getTransaction().commit();
        session.close();

    }


    @Test
    public void insertTest()throws UnsupportedEncodingException{
        Configuration config=new Configuration().configure( "config/hibernate.cfg.xml" );
        SessionFactory sessionFactory=config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        String name=new String("陈倪".getBytes("ISO-8859-1"),"iso-8859-1");
        String city=new String("广州".getBytes(),"utf-8");
        String sex=new String("男".getBytes(),"utf-8");
        Customer customer=new Customer();
        customer.setName(name);
        customer.setAge(20);
        customer.setCity(city);
        customer.setSex(sex);
        session.save(customer);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void updateTest(){
        Configuration config=new Configuration().configure();
        SessionFactory sessionFactory=config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Customer customer=new Customer();
        customer.setId(2);
        customer.setAge(21);
        customer.setName("ostreamBaba");
        customer.setSex("boy");
        customer.setCity("zhongShan");
        session.update(customer);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void findByIdTest(){
        Configuration config=new Configuration().configure();
        SessionFactory sessionFactory=config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Customer customer=(Customer)session.get(Customer.class,2);
        //Customer customer=(Customer)session.load(Customer.class,1);
        System.out.println("name="+customer.getName());
        System.out.println("sex="+customer.getSex());
        System.out.println("age="+customer.getAge());
        System.out.println("city="+customer.getCity());
        transaction.commit();
        session.close();
        sessionFactory.close();
    }


    //删除操作
    @Test
    public void deleteTest(){
        Configuration config=new Configuration().configure();
        SessionFactory sessionFactory=config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        /*for (int i = 7; i < 17; i++) {
            Customer customer=(Customer)session.get(Customer.class,i);
            session.delete(customer);
        }*/
        Customer customer=(Customer)session.get(Customer.class,21                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               );
        session.delete(customer);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }


    //hibernate 一级缓存测试
    //刷出
    @Test
    public void flushTest(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();

        Customer customer=(Customer)session.get(Customer.class,4);
        customer.setName("theONe");
        session.flush();
        session.getTransaction().commit();
        session.close();
    }


    //清除
    @Test
    public void clear(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();

        Customer customer=(Customer)session.get(Customer.class,4);
        System.out.println(customer);
        customer.setName("ostreamBaba");
        /*session.evict(customer);*/  //清除一级缓存的某个对象
        session.clear();
        session.getTransaction().commit();
        session.close();
    }

    //刷新
    @Test
    public void refreshTest(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();
        Customer customer=(Customer)session.get(Customer.class,4);
        customer.setName("theTwo");
        session.refresh(customer);
        session.getTransaction().commit();
        session.close();
    }







}
