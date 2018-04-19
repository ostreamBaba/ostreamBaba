package com.jdbc.service;

/**
 * @Create by ostreamBaba on 18-4-5
 * @描述
 */
public interface AccountDaoService {

    public void transfer(String outUser,String inUser,int money);
}
