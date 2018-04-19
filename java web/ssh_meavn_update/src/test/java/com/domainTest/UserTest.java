package com.domainTest;

import com.domain.entity.User;
import com.domain.util.HibernateUtils;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

/**
 * @Create by ostreamBaba on 18-4-3
 * @描述
 */
public class UserTest {

    @Test
    public void test1(){
        Session session= HibernateUtils.getSession();
        session.beginTransaction();
        User user=(User)session.get(User.class,1);
        System.out.println(user.getId());
        System.out.println(user.getAge());
        System.out.println(user.getUsername());
        session.getTransaction().commit();
        session.close();
    }

    //悲观锁与  乐观锁+version字段
    @Test
    public void test2(){
        Session session= HibernateUtils.getSession();
        session.beginTransaction();
        //User user=(User)session.get(User.class,1,LockMode.UPGRADE_NOWAIT);//悲观锁
        User user=(User)session.get(User.class,1);
        user.setUsername("viscu");
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }


    @Test
    public void test3(){
        Session session= HibernateUtils.getSession();
        session.beginTransaction();
        User user=(User)session.get(User.class,1);
        user.setAge(21);
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
