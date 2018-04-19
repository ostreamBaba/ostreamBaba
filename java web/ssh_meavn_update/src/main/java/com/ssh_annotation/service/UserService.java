package com.ssh_annotation.service;

import com.ssh_annotation.entity.User;

import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-6
 * @ÃèÊö
 */
public interface UserService {
    public void saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public User findById(int id);
    public List<User> findAll();
    public boolean checkLogin(User user);
}
