package com.ssh_annotation.service;

import com.ssh_annotation.dao.UserDao;
import com.ssh_annotation.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-6
 * @√Ë ˆ
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        /*int i=1/0;*/
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        this.userDao.save(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        this.userDao.update(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        this.userDao.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(int id) {
        return this.userDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return this.userDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public boolean checkLogin(User user) {
        return this.userDao.login(user);
    }
}
