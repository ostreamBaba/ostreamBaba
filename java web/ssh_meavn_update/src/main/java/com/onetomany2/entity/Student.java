package com.onetomany2.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @Create by ostreamBaba on 18-4-2
 * @描述
 */
public class Student {

    private Integer id;
    private String name;
    Set<Course> courses=new HashSet<Course>();

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Course> getCourses() {
        return courses;
    }
}
