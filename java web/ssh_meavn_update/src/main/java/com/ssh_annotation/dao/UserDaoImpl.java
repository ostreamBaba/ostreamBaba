package com.ssh_annotation.dao;

import com.ssh_annotation.entity.User;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-6
 * @√Ë ˆ
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao{

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void save(User user) {
        this.hibernateTemplate.save(user);
    }

    @Override
    public void update(User user) {
        this.hibernateTemplate.update(user);
    }

    @Override
    public void delete(User user) {
        this.hibernateTemplate.delete(user);
    }

    @Override
    public User findById(int id) {
        System.out.println(this.hibernateTemplate.get(User.class,id));
        return this.hibernateTemplate.get(User.class,id);
    }

    @Override
    public List<User> findAll() {
        return this.hibernateTemplate.find("from User");
    }

    @Override
    public boolean login(User user) {
        Object[] object=new Object[]{
                user.getUsername(),
                user.getPassword()
        };
        Iterator it=this.hibernateTemplate.find("from User where username=? and password=?",object).iterator();
        if(it.hasNext()){
            return true;
        }else{
            return false;
        }
    }
}
