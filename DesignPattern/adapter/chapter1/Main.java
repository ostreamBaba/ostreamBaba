package com.design.adapter.chapter1;

/**
 * @ Create by ostreamBaba on 18-6-2
 * @ 描述
 */
public class Main {
    public static void main(String[] args) {
        //对于Main类而言,Banner类与其两个方法被完全隐藏起来
        //就类似笔记本电脑只要在直流12伏的电压下就能正常工作，
        //可是他并不知道这12伏的电压是由适配器将100伏特交流电压转换过来的
        Print p=new PrintBanner("viscu");
        p.PrintStrong();
        p.PrintWeak();
    }
}
