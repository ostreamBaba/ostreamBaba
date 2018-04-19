package com.oneToMangTest;

import com.onetomany.entity.Customer;
import com.onetomany.entity.Order;
import com.viscu.util.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

/**
 * @Create by ostreamBaba on 18-4-2
 * @描述
 */
public class OneToManyTest {

    @Test
    public void test1(){
        Session session= HibernateUtils.getSession();
        session.beginTransaction();
        //创建一个客户
        Customer customer=new Customer();
        customer.setName("viscu");
        //创建两张订单
        Order order1=new Order();
        order1.setAddress("bj");
        order1.setPrice(100d);
        Order order2=new Order();
        order2.setAddress("sh");
        order2.setPrice(200d);
        //双向关联
        /*描述关系--订单属于某客户*/
        order1.setCustomer(customer);
        order2.setCustomer(customer);
        /*描述关系--客户有多个订单*/
       /* customer.getOrders().add(order1);
        customer.getOrders().add(order2);*/
        session.save(customer);
        session.save(order1);
        session.save(order2);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void getCustomerOrderTest(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();
        Customer customer=(Customer)session.get(Customer.class,7);
        Set<Order> set=customer.getOrders();
        Iterator it=set.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }

    //test 级联删除
    @Test
    public void delTest(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();
        Customer customer=(Customer)session.get(Customer.class,4);
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
    }

    //孤儿删除 解除父子关系 解除8客户与15订单的关联
    @Test
    public void test2(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();
        Customer customer=(Customer)session.get(Customer.class,8);
        Order order=(Order)session.get(Order.class,15);
        customer.getOrders().remove(order);
        session.getTransaction().commit();
        session.close();
    }

}
