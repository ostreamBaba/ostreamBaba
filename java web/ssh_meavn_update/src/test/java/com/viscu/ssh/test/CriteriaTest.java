package com.viscu.ssh.test;

import com.viscu.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

/**
 * @Create by ostreamBaba on 18-3-31
 * @描述
 */


//criteria.. QBC检索方式
public class CriteriaTest {

    @Test
    public void qbcTest(){
        Configuration configuration=new Configuration().configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria=session.createCriteria(Customer.class);
        criteria.add( Restrictions.eq("name","OSTREAMBABA"));
        List<Customer> list=criteria.list();
        for(Customer customer:list){
            System.out.println(customer);
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}
