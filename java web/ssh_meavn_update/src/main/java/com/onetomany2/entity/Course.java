package com.onetomany2.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @Create by ostreamBaba on 18-4-2
 * @描述
 */
public class Course {

    private Integer id;
    private String name;
    private Set<Student> students=new HashSet<Student>();
    private Set<Grade> grades=new HashSet<Grade>();
    private Student student;
    private Grade grade;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Student getStudent() {
        return student;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
