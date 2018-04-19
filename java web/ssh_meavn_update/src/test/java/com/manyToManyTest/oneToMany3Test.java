package com.manyToManyTest;

import com.onetomany3.entity.Course;
import com.onetomany3.entity.Grade;
import com.onetomany3.entity.Student;
import com.onetomany3.util.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Create by ostreamBaba on 18-4-3
 * @描述
 */
public class oneToMany3Test {

    @Test
    public void test(){
        Session session= HibernateUtils.getSession();
        session.beginTransaction();

        Student s1=new Student();
        s1.setName("li");
        Student s2=new Student();
        s2.setName("young");

        //一个学生多条选课记录
        Grade g1=new Grade();
        g1.setGrade(100);
        Grade g2=new Grade();
        g2.setGrade(200);
        Grade g3=new Grade();
        g3.setGrade(123);
        //s1考了两门
        Set<Grade> gradesS1=new HashSet<Grade>();
        gradesS1.add(g1);
        gradesS1.add(g2);
        s1.setGrades(gradesS1);
        //s2考了一门
        Set<Grade> gradesS2=new HashSet<Grade>();
        gradesS2.add(g3);
        s2.setGrades(gradesS2);

        //两门课
        Course c1=new Course();
        c1.setName("English");
        Course c2=new Course();
        c2.setName("Math");


        //一门课对应一条选课记录,但可以被多次选,被g1被s1选了一次,g3被s2选了一次
        Set<Grade> grades2=new HashSet<Grade>();
        grades2.add(g1);
        grades2.add(g3);

        Set<Grade> grades3=new HashSet<Grade>();
        grades3.add(g2);

        c1.setGrades(grades2);//c1有两门成绩
        c2.setGrades(grades3);//c2有一门成绩

        session.save(g1);
        session.save(g2);
        session.save(g3);
        session.save(s1);
        session.save(s2);
        session.save(c1);
        session.save(c2);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void test1(){
        Session session= HibernateUtils.getSession();
        session.beginTransaction();
        Grade grade=(Grade)session.get(Grade.class,3);
        String str=grade.getStudent().getName()+": "+grade.getCourse().getName()+"这门课考了"+grade.getGrade()+"分";
        System.out.println(str);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void test2(){
        Session session= HibernateUtils.getSession();
        session.beginTransaction();
        Student student1=(Student)session.get(Student.class,4);
        Iterator it1=student1.getGrades().iterator();
        while(it1.hasNext()){
            System.out.println(it1.next().toString());
        }
        Student student2=(Student)session.get(Student.class,5);
        Iterator it2=student2.getGrades().iterator();
        while(it2.hasNext()){
            System.out.println(it2.next().toString());
        }
        session.getTransaction().commit();
        session.close();
    }
}
