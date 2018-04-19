package com.manyToManyTest;

import com.manytomany.entity.Role;
import com.manytomany.entity.User;
import com.manytomany.util.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Create by ostreamBaba on 18-4-2
 * @描述
 */
public class manyToManyTest {


    //双向多对多
    @Test
    public void test(){
        Session session= HibernateUtils.getSession();
        session.beginTransaction();

        /*t_User_Role t_user_role=new t_User_Role();*/
        /*t_user_role.setUser(user1);
        t_user_role.setRole(role1);
        t_user_role.setRole(role2);*/

        User user1=new User();
        user1.setName("test1");
        User user2=new User();
        user2.setName("test2");


        Role role1=new Role();
        role1.setName("role1");
        session.save(role1);
        Role role2=new Role();
        role2.setName("role2");
        session.save(role2);

        Set<Role> roles1=new HashSet<Role>();
        roles1.add(role1);
        roles1.add(role2);
        user1.setRoles(roles1);
        session.save(user1);

        Set<Role> roles2=new HashSet<Role>();
        roles2.add(role1);
        roles2.add(role2);
        user2.setRoles(roles2);

        //test 反转操作
        /*role1.getUsers().add(user1);
        role1.getUsers().add(user2);
        role2.getUsers().add(user1);
        role2.getUsers().add(user2);*/

        session.save(user2);

        session.getTransaction().commit();
        session.close();
    }

    /*@Test
    public void UpdateTest(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();
        User user=(User)session.get(User.class,25);
        session.getTransaction().commit();
        session.close();
    }*/

    //test级联操作
    @Test
    public void test3(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();

        User user=new User();
        user.setName("liFour");

        Role role=new Role();
        role.setName("boss");

        user.getRoles().add(role);

        session.save(user); //insert user->持久态 关联 role瞬时态 cascade="save-update"将role变成持久态
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void test1(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();
        User user=(User)session.get(User.class, 8);
        String uRl=user.getName().toString()+": ";
        for(Role role: user.getRoles()){
            uRl+=role.getName()+",";
        }
        uRl=uRl.substring(0,uRl.length()-1);
        System.out.println(uRl);
        session.getTransaction().commit();
        session.close();
    }


    @Test
    public void test2(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();
        Role role=(Role)session.get(Role.class,5);
        String rSt=role.getName()+": ";
        for(User u:role.getUsers()){
            rSt+=u.getName()+",";
        }
        rSt=rSt.substring(0,rSt.length()-1);
        System.out.println(rSt);
        session.getTransaction().commit();
        session.close();
    }

    //多对多级联删除 删除15用户 及其所关联的所以课程 已经所以与15用户关联的课程有关联的用户
    @Test
    public void delTest(){
        Session session=HibernateUtils.getSession();
        session.beginTransaction();
        User user=(User)session.get(User.class,21);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }


}
