package com.ostream.effective_java.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Create by ostreamBaba on 18-5-5
 * @描述
 */

//慎用重载
public class chapter41 {
}

final class SetList{
    public static void main(String[] args) {
        Set<Integer> set=new TreeSet<Integer>();
        List<Integer> list=new ArrayList<Integer>();
        for (int i = -3; i < 3; i++) {
            set.add(i); //autoboxing
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            set.remove(i); //移除某个值
            //list.remove(i);  //重载 移除某个位置的值 debug一遍
            list.remove((Integer)i);
        }
        System.out.println(set);
        System.out.println(list);
    }
}
