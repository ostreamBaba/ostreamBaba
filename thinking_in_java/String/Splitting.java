package com.ostream.ThinkingInJavaII.string;

import java.util.Arrays;

/**
 * @Create by ostreamBaba on 18-4-22
 * @描述
 */
public class Splitting {
    public static String sp="" +
            "Then, when you have found the xx, you must "+
            "cut down the mightiest tree int the forest..."+
            "with...a herring!!!!!";
    public static void split(String regex){
        System.out.println(Arrays.toString(sp.split(regex)));
    }
    //split配合正则表达式
    public static void main(String[] args) {
        split(" ");
        split("\\W+"); // \W 表示一个非单词字符
        split("n\\W+");  //表示n后面跟着一个或者多个非单词字符
    }
}

class Replacing{
    static String s=Splitting.sp;
    public static void main(String[] args) {
        System.out.println(s.replaceFirst("f\\w+","located"));  //替换第一个f后面跟着一个或者多个小写字母
        System.out.println(s.replaceAll("xx|tree|herring","banana"));//替换所有符合单词(匹配上三个单词其中任意一个)
    }
}
