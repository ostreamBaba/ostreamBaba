package com.jdbc;


import com.jdbc.Dao.UserDao;
import com.jdbc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-5
 * @描述
 */



public class test {

    private static final String XMLPATH;
    private static final ApplicationContext APPLICATION_CONTEXT;
    private static final UserDao USER_DAO;

    static {
        XMLPATH="/config/jdbcTemplate.xml";
        APPLICATION_CONTEXT=new ClassPathXmlApplicationContext(XMLPATH);
        USER_DAO=(UserDao) APPLICATION_CONTEXT.getBean("userDao");
    }

    @Test
    public void create(){
        JdbcTemplate jdbcTemplate=(JdbcTemplate)APPLICATION_CONTEXT.getBean("jdbcTemplate");
        jdbcTemplate.execute("CREATE TABLE jdbc_user("+
            "userId int PRIMARY KEY auto_increment,"+
                "username VARCHAR(50),"+
                "password VARCHAR(32))");
    }

    @Test
    public void addUserTest(){
        User user=new User();
        user.setUsername("lil");
        user.setPassword("1234");
        int flag=USER_DAO.addUser(user);
        if(1==flag){
            System.out.println("添加成功");
        }else{
            System.out.println("添加成功");
        }
    }

    @Test
    public void updateUserTest(){
        User user=new User();
        user.setUserId(2);
        user.setUsername("Tom");
        user.setPassword("234");
        int flag=USER_DAO.update(user);
        if(1==flag){
            System.out.println("success");
        }else{
            System.out.println("failed");
        }
    }

    @Test
    public void delTest(){
        int id=3;
        int flag=USER_DAO.deleteUserById(id);
        if(1==flag){
            System.out.println("success");
        }else {
            System.out.println("fail");
        }
    }

    @Test
    public void findByIdTest(){
        int id=2;
        User user=USER_DAO.findById(id);
        System.out.println(user);
    }

    @Test
    public void findAllUserTest(){
        List<User> list=USER_DAO.findAllUser();
        Iterator it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }

}
