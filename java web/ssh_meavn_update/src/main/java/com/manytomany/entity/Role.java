package com.manytomany.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @Create by ostreamBaba on 18-4-2
 * @描述
 */
public class Role {

    private Integer id;
    private String name;
    Set<User> users=new HashSet<User>();

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
