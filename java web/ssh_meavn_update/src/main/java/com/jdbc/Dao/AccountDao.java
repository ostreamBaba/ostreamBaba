package com.jdbc.Dao;

/**
 * @Create by ostreamBaba on 18-4-5
 * @描述
 */
public interface AccountDao {

    public void out(String outUser,int money);
    public void in(String inUser,int money);

}
