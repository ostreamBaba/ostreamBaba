package com.onetomany2.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @Create by ostreamBaba on 18-4-2
 * @描述
 */
public class Grade {

    private Integer id;
    private Integer grade;
    Set<Course> courses=new HashSet<Course>();

    public Integer getId() {
        return id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
