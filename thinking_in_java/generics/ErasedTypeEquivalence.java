package com.ostream.ThinkingInJavaII.generics;

import java.util.*;

/**
 * @Create by ostreamBaba on 18-4-24
 * @描述
 */

//即使两者的行为是不同的
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1=new ArrayList<String>().getClass();
        Class c2=new ArrayList<Integer>().getClass();
        System.out.println(c1);
        System.out.println(c1==c2);
        //true
    }

}

class Frob{}
class Fnorkle{}

//在泛型代码内部 无法获取任何有关泛型参数类型的信息
class LostInformation{
    public static void main(String[] args) {
        List<Frob> list=new ArrayList<Frob>();
        Queue<Fnorkle> queue=new LinkedList<Fnorkle>();
        Map<Frob,Fnorkle> map=new HashMap<Frob, Fnorkle>();
        System.out.println( Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(queue.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
    }
}