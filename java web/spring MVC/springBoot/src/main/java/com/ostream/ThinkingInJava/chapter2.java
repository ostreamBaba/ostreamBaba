package com.ostream.ThinkingInJava;

import static com.ostream.ThinkingInJava.Print.*;

/**
 * @Create by ostreamBaba on 18-4-16
 * @描述
 */
public class chapter2 {

    public chapter2(){}

    void bit(){
        System.out.println("bit()");
    }

    public static void main(String[] args) {
        String s="print";
        printnb(s+" ");
        print(s);
        print(100L);
        int a=1;
        printf("I'm No. %d!!",a);
    }

}
