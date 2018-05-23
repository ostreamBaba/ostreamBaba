package com.viscu.service.impl;

import com.viscu.dao.UserDao;
import com.viscu.model.User;
import com.viscu.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Create by ostreamBaba on 18-5-23
 * @ √Ë ˆ
 */

@Service
public class UserDaoServiceImpl implements UserDaoService{

    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public User findUserById(long id) {
        return this.userDao.select(id);
    }
}
