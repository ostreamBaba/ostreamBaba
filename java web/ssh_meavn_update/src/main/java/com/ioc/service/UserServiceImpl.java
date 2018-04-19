package com.ioc.service;

import com.ioc.dao.UserDao;

/**
 * @Create by ostreamBaba on 18-4-3
 * @描述
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        this.userDao.save();
        System.out.println("fuck springin'");
    }
}
