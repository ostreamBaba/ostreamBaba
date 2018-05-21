package com.viscu.springboot.model;

/**
 * @ Create by ostreamBaba on 18-5-21
 * @ 描述
 */
public class Person {
    private String name;
    private Integer age;
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
