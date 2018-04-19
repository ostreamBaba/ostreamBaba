package com.ostream.test;

import org.junit.Test;

/**
 * @Create by ostreamBaba on 18-4-12
 * @描述
 */

public class static_test {

    static int i=0;
    static {
        ++i;
        System.out.println("1: "+i);
    }
    public static void output(){
        ++i;
        System.out.println("2: "+i);
    }
    public void say(){
        System.out.println("no static");
    }
    public static void main(String[] args) {
        static_test test=new static_test();
        static_test.output();
    }

}


