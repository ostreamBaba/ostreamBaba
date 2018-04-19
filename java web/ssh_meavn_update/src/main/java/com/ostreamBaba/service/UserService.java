package com.ostreamBaba.service;

import com.ostreamBaba.entity.User;

import java.util.List;

/**
 * @Create by ostreamBaba on 18-3-28
 * @描述
 */
public interface UserService {
    public boolean addUser(User user);

    public boolean login(User user);

    public List getAllUser();

    public User getUserById(int id);

    public boolean updateUser(User user);

    public boolean deleteUser(int id);
}
