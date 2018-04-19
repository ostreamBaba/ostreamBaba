package com.aspect.dao;

import org.springframework.stereotype.Repository;

/**
 * @Create by ostreamBaba on 18-4-4
 * @描述
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("sava");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void find() {
        System.out.println("find");
    }
}
