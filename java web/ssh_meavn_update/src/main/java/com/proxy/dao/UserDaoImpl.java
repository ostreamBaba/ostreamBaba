package com.proxy.dao;

/**
 * @Create by ostreamBaba on 18-4-4
 * @描述
 */
public class UserDaoImpl implements UserDao{

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
