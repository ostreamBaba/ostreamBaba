package com.ostream.ThinkingInJavaII.generics;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-26
 * @描述
 */

//逆变 超类型通配符

class Sonn extends Son{}

class SuperTypeWildType{
    static void WriteTo(List<? super Son> list){
        list.add(new Son());
        list.add(new Sonn());
        //list.add(new Father());
    }
}

public class GenericWriting {

    static <T> void WriteExact(List<T> list,T item){
        /*System.out.println("List<T>: "+list.getClass());
        System.out.println("T: "+item.getClass());*/
        list.add(item);
    }
    static List<Son> sonList=new ArrayList<Son>();
    static List<Father> fatherList=new ArrayList<Father>();
    static void f1(){
        WriteExact(sonList,new Son());
        WriteExact(fatherList,new Son());
        //显示的泛型方法
        GenericWriting.<Father>WriteExact(fatherList,new Son());
        //! GenericWriting.<Son>WriteExact(fatherList,new Son());
    }
    static <T> void WriteExact1(List<? super T> list,T item){
        list.add(item);
    }
    static void f2(){
        WriteExact1(sonList,new Son());
        WriteExact1(fatherList,new Son());
    }
    public static void main(String[] args) {
        /*f1();
        System.out.println(sonList);
        System.out.println(fatherList.getClass());
        f2();
        System.out.println(fatherList);*/
    }
}
