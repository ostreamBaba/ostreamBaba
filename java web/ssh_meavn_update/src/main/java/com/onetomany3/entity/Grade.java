package com.onetomany3.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @Create by ostreamBaba on 18-4-2
 * @描述
 */
public class Grade {

    private Integer id;
    private Integer grade;
    private Course course;
    private Student student;

    public Integer getId() {
        return id;
    }

    public Integer getGrade() {
        return grade;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return student.getName()+": "+course.getName()+"这门课考了"+grade+"分";
    }
}
