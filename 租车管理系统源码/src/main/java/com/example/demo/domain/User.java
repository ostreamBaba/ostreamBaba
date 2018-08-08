package com.example.demo.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

   /* @NotEmpty(message = "用户名不能为空")
    @Length(min = 6,max = 16, message = "用户名长度在6到16之间")*/
    private String name;

    /*@NotEmpty(message = "密码不能为空")
    @Length(min = 6,max = 16,message = "密码在6到16之间")*/
    private String password;

    /*@NotEmpty(message = "邮箱不能为空")*/
    private String email;

    public User() {
        super();
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
