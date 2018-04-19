package com.viscu.ssh.test;

import com.viscu.entity.Customer;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-3-31
 * @描述
 */
public class QueryTest {

    @Test
    public void findAll_hqlTest(){

        Configuration config=new Configuration().configure();
        SessionFactory sessionFactory=config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        //SQLQuery sqlQuer=session.createSQLQuery("SELECT id,name FROM MyStrugglle.customer");
        String hql="from Customer";
        Query query=session.createQuery(hql);
        List<Customer> list=query.list();
        for(Customer c:list){
            System.out.println(c);
        }
        transaction.commit();
        session.close();
    }



}
