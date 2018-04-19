package com.jdbc.Dao;

import com.jdbc.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-5
 * @描述
 */

@Transactional(rollbackOn = Exception.class)
//回滚
@Repository("userDao")
public class UserDaoImpl implements UserDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(User user) {
        String sql="insert into jdbc_user(username,password)value(?,?)";
        Object[] objects=new Object[]{
                user.getUsername(),
                user.getPassword()
        };
        int flag=this.jdbcTemplate.update(sql,objects);
        return flag;
    }

    @Override
    public int update(User user) {
        String sql="update jdbc_user set username=?"+
                ",password=?where userId=?";
        Object[] objects=new Object[]{
                user.getUsername(),
                user.getPassword(),
                user.getUserId()
        };
        int flag=this.jdbcTemplate.update(sql,objects);
        return flag;
    }

    @Override
    public int deleteUserById(int id) {
        String sql="delete from jdbc_user where userId=?";
        int flag=this.jdbcTemplate.update(sql,id);
        return flag;
    }

    @Override
    public User findById(int id) {
        String sql="select * from jdbc_user where userId=?";
        RowMapper<User> userRowMapper= ParameterizedBeanPropertyRowMapper.newInstance(User.class);
        return this.jdbcTemplate.queryForObject(sql,userRowMapper,id);
    }

    @Override
    public List<User> findAllUser() {
        String sql="select * from jdbc_user";
        RowMapper<User> userRowMapper=ParameterizedBeanPropertyRowMapper.newInstance(User.class);
        return this.jdbcTemplate.query(sql,userRowMapper);
    }
}
