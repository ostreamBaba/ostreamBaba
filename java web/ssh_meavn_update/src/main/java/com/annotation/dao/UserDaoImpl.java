package com.annotation.dao;

import org.springframework.stereotype.Repository;

/**
 * @Create by ostreamBaba on 18-4-3
 * @描述
 */

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("userDao....save...");
    }
}
