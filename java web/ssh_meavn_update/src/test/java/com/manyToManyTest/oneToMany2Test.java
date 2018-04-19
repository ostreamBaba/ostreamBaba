package com.manyToManyTest;

import com.onetomany2.entity.Course;
import com.onetomany2.entity.Grade;
import com.onetomany2.entity.Student;
import com.onetomany2.util.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Create by ostreamBaba on 18-4-3
 * @描述
 */
public class oneToMany2Test {

    @Test
    public void test(){
        Session session= HibernateUtils.getSession();
        session.beginTransaction();

        Student s1=new Student();
        s1.setName("ff");
        /*Student s2=new Student();
        s2.setName("pump");
        session.save(s2);*/
        Course c1=new Course();
        c1.setName("English");
        Course c2=new Course();
        c2.setName("Math");

        Grade g1=new Grade();
        g1.setGrade(100);
        Set<Grade> grades=new HashSet<Grade>();
        grades.add(g1);



        Set<Course> courses=new HashSet<Course>();
        courses.add(c1);
        courses.add(c2);
        s1.setCourses(courses);


        session.save(c1);
        session.save(c2);
        session.save(s1);


        session.getTransaction().commit();
        session.close();

    }

}
