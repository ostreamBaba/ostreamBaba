package com.onetomany3.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @Create by ostreamBaba on 18-4-2
 * @描述
 */
public class Course {

    private Integer id;
    private String name;
    private Set<Grade> grades=new HashSet<Grade>();

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }
}
