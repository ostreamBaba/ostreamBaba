package com.domainTest;

import com.domain.entity.User;
import com.domain.util.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

/**
 * @Create by ostreamBaba on 18-4-3
 * @描述
 */
public class SecondEHCacheTest {

    @Test
    public void testCache(){
        Session session1=HibernateUtils.getSession();
        session1.beginTransaction();
        User user1=(User)session1.get(User.class,1);
        User user2=(User)session1.get(User.class,1);
        System.out.println(user1==user2);
        session1.getTransaction().commit();
        session1.close();
        Session session2=HibernateUtils.getSession();
        session2.beginTransaction();
        User user3=(User)session2.get(User.class,1);
        System.out.println(user1==user3);
        User user4=(User)session2.get(User.class,1);
        System.out.println(user3==user4);
        session2.getTransaction().commit();
        session2.close();

    }

}
