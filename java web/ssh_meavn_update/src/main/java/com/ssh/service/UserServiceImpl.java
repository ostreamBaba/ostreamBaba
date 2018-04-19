package com.ssh.service;

import com.ssh.dao.UserDao;
import com.ssh.entity.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-6
 * @描述
 */
@Transactional(propagation = Propagation.REQUIRED,
    isolation = Isolation.DEFAULT,readOnly = false)
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        /*int i=1/0;*/
        this.userDao = userDao;
    }

    @Override
    public void saveUser(User user) {
        this.userDao.save(user);
    }

    @Override
    public void updateUser(User user) {
        this.userDao.update(user);
    }

    @Override
    public void deleteUser(User user) {
        this.userDao.delete(user);
    }

    @Override
    public User findById(int id) {
        return this.userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return this.userDao.findAll();
    }
}
