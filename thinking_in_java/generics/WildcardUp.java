package com.ostream.ThinkingInJavaII.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-24
 * @描述
 */
// List<? extends T>
//<? extends T> 表示类型的上界，表示参数化类型的可能是T或是T的子类;
//上界<? extends T>不能往里存，只能往外取
///List<?>单纯的就表示：集合里放了一个东西，是什么我不知道。
class Father{}
class Son extends Father{}
class D extends Father{}

class test{
    public static List<Father> getFatherList(){
        ArrayList<Father> list=new ArrayList<Father>();
        list.add(new Son());
        list.add(new Father());
        list.add(new D());
        return list;
    }
}
public class WildcardUp{
    public static void main(String[] args) {
        List<? extends Father> list=test.getFatherList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
