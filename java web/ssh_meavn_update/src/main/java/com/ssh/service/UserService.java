package com.ssh.service;

import com.ssh.entity.User;

import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-6
 * @描述
 */
public interface UserService {
    public void saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public User findById(int id);
    public List<User> findAll();

}
