package com.springboot.security.dao;

import com.springboot.security.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @ Create by ostreamBaba on 18-5-26
 * @ 描述
 */

public interface SysUserRepository extends JpaRepository<SysUser,Long>{
    SysUser findByUsername(String username);
}
