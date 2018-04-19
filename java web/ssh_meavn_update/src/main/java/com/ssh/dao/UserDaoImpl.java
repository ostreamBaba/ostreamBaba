package com.ssh.dao;

import com.ssh.entity.User;
import org.springframework.orm.hibernate3.HibernateTemplate;


import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-6
 * @描述
 */
public class UserDaoImpl implements UserDao{

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
        return this.hibernateTemplate.get(User.class,id);
    }

    @Override
    public List<User> findAll() {
        return this.hibernateTemplate.find("from User");
    }
}
