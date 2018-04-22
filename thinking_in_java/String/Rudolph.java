package com.ostream.ThinkingInJavaII.string;

/**
 * @Create by ostreamBaba on 18-4-22
 * @描述
 */


public class Rudolph {
    public static void main(String[] args) {
        for(String pattern:new String[]{
                "Rudolph","[rR]udolph",
                "[rR][aeiou][a-z]ol.*","R.*"}){
            System.out.println("Rudolph".matches(pattern));
        }
    }
}

//true
//true
//true
//true
