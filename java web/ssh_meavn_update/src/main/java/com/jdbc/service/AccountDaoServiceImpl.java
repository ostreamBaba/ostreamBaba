package com.jdbc.service;

import com.jdbc.Dao.AccountDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Create by ostreamBaba on 18-4-5
 * @描述
 */


@Transactional(propagation=Propagation.REQUIRED,
    isolation= Isolation.DEFAULT,readOnly=false)
public class AccountDaoServiceImpl implements AccountDaoService{

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outUser, String inUser, int money) {
        this.accountDao.out(outUser,money);
        //模拟断电
        /*int i=1/0;*/
        this.accountDao.in(inUser,money);
    }
}
