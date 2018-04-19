package com.domain.entity;

/**
 * @Create by ostreamBaba on 18-4-3
 * @描述
 */
public class User {

    private Integer id;
    private String username;
    private Integer age;
    private Integer version;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
