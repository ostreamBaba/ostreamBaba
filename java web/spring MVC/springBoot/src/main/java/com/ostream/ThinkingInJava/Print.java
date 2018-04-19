package com.ostream.ThinkingInJava;

import java.io.PrintStream;

/**
 * @Create by ostreamBaba on 18-4-16
 * @描述
 */
public class Print {

    public static void print(Object object){
        System.out.println(object);
    }

    public static void print(){
        System.out.println();
    }

    public static void printnb(Object object){
        System.out.print(object);
    }

    public static PrintStream printf(String format,Object... objects){
        return System.out.printf(format,objects);
    }
}
