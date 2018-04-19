package com.ssh.dao;

import com.ssh.entity.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-6
 * @描述
 */
public class    UserDaoImpll extends HibernateDaoSupport implements UserDao{

    @Override
    public void save(User user) {
        this.getHibernateTemplate().save(user);
    }

    @Override
    public void update(User user) {
        this.getHibernateTemplate().update(user);
    }

    @Override
    public void delete(User user) {
        this.getHibernateTemplate().delete(user);
    }

    @Override
    public User findById(int id) {
        return this.getHibernateTemplate().get(User.class,id);
    }

    @Override
    public List<User> findAll() {
        return this.getHibernateTemplate().find("from User");
    }
}
