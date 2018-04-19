package com.jdbc.Dao;

import com.jdbc.entity.User;

import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-5
 * @描述
 */
public interface UserDao {

    public int addUser(User user);
    public int update(User user);
    public int deleteUserById(int id);
    public User findById(int id);
    public List<User> findAllUser();
}
