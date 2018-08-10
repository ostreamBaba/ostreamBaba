package com.ThinkingInJava.capter17.Set;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @ Create by ostreamBaba on 18-8-10
 * @ 描述
 */
public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet=new TreeSet<String>();
        Collections.addAll(sortedSet,"one two three four five six seven eight".split("\\s+"));
        System.out.println(sortedSet);

        String first=sortedSet.first();
        String last=sortedSet.last();

        System.out.println(first+" "+last);
        Iterator<String> it=sortedSet.iterator();
        for (int i = 0; i <= 6; i++) {
            if(i==3){
                first=it.next();
            }else if(i==6){
                last=it.next();
            }else{
                it.next();
            }
        }
        System.out.println(first+" "+last);
        System.out.println(sortedSet.subSet(first,last)); //生产Set的子集 [first,second)
        System.out.println(sortedSet.headSet(last)); //[first,toElement)
        System.out.println(sortedSet.tailSet(first));//[fromElement,last]

    }
}
