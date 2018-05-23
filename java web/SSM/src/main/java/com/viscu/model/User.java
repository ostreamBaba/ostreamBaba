package com.viscu.model;

/**
 * @ Create by ostreamBaba on 18-5-23
 * @ √Ë ˆ
 */
public class User {
    private long id;
    private String name;
    private String password;
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
