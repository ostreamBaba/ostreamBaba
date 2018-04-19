package com.ssh_annotation.entity;

import javax.persistence.*;

/**
 * @Create by ostreamBaba on 18-4-6
 * @描述
 */
@Entity
@Table(name = "jdbc_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    @Column(name = "username", length = 20)
    private String username;
    @Column(name = "password", length = 20)
    private String password;

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
