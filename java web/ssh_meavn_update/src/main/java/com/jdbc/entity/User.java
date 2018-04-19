package com.jdbc.entity;

/**
 * @Create by ostreamBaba on 18-4-5
 * @描述
 */
public class User {


    private Integer userId;
    private String username;
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

    @Override
    public String toString() {
        return "UserDao [userId="+userId
                +",username="+username
                +",password"+password+"]";
    }
}
