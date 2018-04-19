package com.ssh_annotation.dao;

import com.ssh_annotation.entity.User;

import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-6
 * @ÃèÊö
 */
public interface UserDao {
    public void save(User user);
    public void update(User user);
    public void delete(User user);
    public User findById(int id);
    public List<User> findAll();
    public boolean login(User user);
}
