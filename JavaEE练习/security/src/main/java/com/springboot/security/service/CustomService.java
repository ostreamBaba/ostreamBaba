package com.springboot.security.service;

import com.springboot.security.dao.SysUserRepository;
import com.springboot.security.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @ Create by ostreamBaba on 18-5-26
 * @ 通用的用户
 */
public class CustomService implements UserDetailsService {

    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user=sysUserRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }
}
