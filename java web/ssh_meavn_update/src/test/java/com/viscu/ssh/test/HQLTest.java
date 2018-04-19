package com.viscu.ssh.test;

import com.viscu.entity.Customer;
import com.viscu.util.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Iterator;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-3
 * @描述
 */
public class HQLTest {

    @Test
    public void aliasTest(){
        Session session= HibernateUtils.getSession();
        session.beginTransaction();

        String hql="from Customer as c where c.name='ostreambaba'";
        Query query=session.createQuery(hql);
        List<Customer> customers=query.list();
        System.out.println(customers.size());
        for(Customer c:customers){
            System.out.println(c);
        }
        session.getTransaction().commit();
        session.close();
    }

    //投影查询
    @Test
    public void portionQueryTest(){
        Session session= HibernateUtils.getSession();
        session.beginTransaction();

        String hql="select c.name,c.age from Customer as c";
        Query query=session.createQuery(hql);
        List<Object[]> list=query.list();
        Iterator it=list.iterator();
        while(it.hasNext()){
            Object[] objects=(Object[])it.next();
            System.out.println(objects[0]+" "+objects[1]);
        }

        session.getTransaction().commit();
        session.close();
    }

    //动态查询
    @Test
    public void dynamicQueryTest(){
        Session session= HibernateUtils.getSession();
        session.beginTransaction();

        String hql="select new Customer(c.name,c.age) from Customer as c";
        Query query=session.createQuery(hql);
        List<Customer> list=query.list(); //实体类
        for(Customer c:list){
            System.out.println(c.getName()+" "+c.getAge());
        }

        session.getTransaction().commit();
        session.close();
    }

    //条件查询
    @Test
    public void paramQueryTest(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();

        String hql="from Customer where name like?";
        Query query=session.createQuery(hql);
        query.setString(0,"%s%");
        List<Customer> list=query.list();
        for(Customer c:list){
            System.out.println(c);
        }
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void paramQueryTest1(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();

        String hql="from Customer where id=:id";
        Query query=session.createQuery(hql);
        query.setParameter("id",2);
        List<Customer> list=query.list();
        for(Customer c:list){
            System.out.println(c);
        }
        session.getTransaction().commit();
        session.close();

    }


}
