package com.ostream.ThinkingInJavaII.generics;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @Create by ostreamBaba on 18-4-24
 * @描述
 */
public class Sets {

    //合并两个set
    public static <T> Set<T> union(Set<T> a,Set<T> b){
        Set<T> res=new HashSet<T>(a);
        res.addAll(b);
        return res;
    }
    //求两个set的交集
    public static <T> Set<T> intersection(Set<T> a,Set<T> b){
        Set<T> res=new HashSet<T>(a);
        res.retainAll(b);
        return res;
    }
    //从xx中删除所有有关x中包含的元素
    public static <T> Set<T> difference(Set<T> subset,Set<T> superset){
        Set<T> res=new HashSet<T>(superset);
        res.removeAll(subset);
        return res;
    }
    //将两个集合合并成一个没有共同元素的集合
    public static <T> Set<T> complement(Set<T> a,Set<T> b){
        return union(a,difference(intersection(a,b),b));
    }
}

enum Number{
    ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN
}

class testSets{
    public static void main(String[] args) {
        Set<Integer> s1=new HashSet<Integer>();
        Set<Integer> s2=new HashSet<Integer>();
        for (int i = 0; i < 4; i++) {
            s1.add(i);
        }
        for (int i = 2; i < 6; i++) {
            s2.add(i);
        }
        System.out.println(Sets.complement(s1,s2));
        Set<Number> s3= EnumSet.range(Number.ONE,Number.SIX);
        Set<Number> s4=EnumSet.range(Number.FIVE,Number.SEVEN);
        System.out.println(Sets.complement(s3,s4));
    }
}
