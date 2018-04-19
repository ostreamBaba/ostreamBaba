package com.ostreamBaba.service;

import com.ostreamBaba.dao.UserDao;
import com.ostreamBaba.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-3-28
 * @描述
 */

@Service("userService")
public class UserServiceImpl implements UserService{

    //自动注入userDao，也可以使用@Autowired
    @Resource
    private UserDao userDao;


    @Override
    public boolean addUser(User user) {
        this.userDao.add(user);
        return true;
    }

    @Override
    public boolean login(User user) {
        return this.userDao.login(user);
    }

    @Override
    public List getAllUser() {
        return this.userDao.getUser();
    }

    @Override
    public User getUserById(int id) {
        return this.userDao.getUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        this.userDao.update(user);
        return true;

    }

    @Override
    public boolean deleteUser(int id) {
        this.userDao.delete(id);
        return true;
    }
}


