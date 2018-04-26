package com.ostream.ThinkingInJavaII.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-26
 * @描述
 */

//协变与通配符

/*
 * Arrays.asList()
 * 首先，该方法是将数组转化为list。有以下几点需要注意：
 * (1）该方法不适用于基本数据类型（byte,short,int,long,float,double,boolean）
 * (2）该方法将数组与列表链接起来，当更新其中之一时，另一个自动更新
 * (3）不支持add和remove方法
 */

public class GenericReading {
    static <T> T readExact(List<T> list){
        return list.get(0);
    }
    static List<Son> sonList=Arrays.asList(new Son());
    static List<Father> fatherList= Arrays.asList(new Father());
    static void f1(){
        Son s=readExact(sonList);
        Father f=readExact(fatherList);
        f=readExact(sonList);
        System.out.println(f+"\n"+s);
    }
    static class Reader<T>{
       T readExact(List<T> list){
           return list.get(0);
       }
    }
    static void f2(){
        Reader<Father> fatherReader=new Reader<Father>();//只能存入father类的list
        Father f=fatherReader.readExact(fatherList);
        //! f=fatherReader.readExact(sonList);  //error
    }
    static class Reader1<T>{
        T readExact(List<? extends T> list){
            return list.get(0);
        }
    }
    static void f3(){
        Reader1<Father> fatherReader1=new Reader1<Father>();
        Father f=fatherReader1.readExact(fatherList);
        Father f1=fatherReader1.readExact(sonList);
        System.out.println(f+"\n"+f1);
    }
    public static void main(String[] args) {
        f3();
    }
}
