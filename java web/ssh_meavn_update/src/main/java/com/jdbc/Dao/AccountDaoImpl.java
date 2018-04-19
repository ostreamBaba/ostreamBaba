package com.jdbc.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @Create by ostreamBaba on 18-4-5
 * @描述
 */

/*@Transactional(rollbackOn = Exception.class)
@Repository("accountDao")*/
public class AccountDaoImpl implements AccountDao{

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void out(String outUser, int money) {
        String sql="update account set money=money-? where name=?";
        this.jdbcTemplate.update(sql,money,outUser);
    }

    @Override
    public void in(String inUser, int money) {
        String sql="update account set money=money+? where name=?";
        this.jdbcTemplate.update(sql,money,inUser);
    }
}
