package com.springboot.security.domain;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ Create by ostreamBaba on 18-5-26
 * @ 让我们用户的实体实现UserDetails 我们的用户实体即为Spring Security所使用的用户
 */

@Entity
public class SysUser implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    //CascadeType.REFRESH：级联刷新，当多个用户同时作操作一个实体，为了用户取到的数据是实时的，在用实体中的数据之前就可以调用一下refresh()方法
    //FetchType.EAGER：急加载 其中定义是急加载的的属性(property)和字段(field)会立即从数据库中加载
    private List<SysRole> roles; //配置用户和角色的多对多关系

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {  //重写 将用户的角色作为权限
        List<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();
        List<SysRole> roles=this.getRoles();
        for(SysRole role:roles){
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
