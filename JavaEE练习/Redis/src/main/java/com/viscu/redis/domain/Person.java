package com.viscu.redis.domain;

import java.io.Serializable;

/**
 * @ Create by ostreamBaba on 18-5-26
 * @ 描述
 */
public class Person implements Serializable{
    private static final Long serialVersionUID=1L;
    public Person() { }

    private String id;
    private String name;
    private Integer age;

    public Person(String id, String name, Integer age) {
        super(); //此类必须使用时间序列化接口 因为使用jackson做序列化需要一个空构造
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
