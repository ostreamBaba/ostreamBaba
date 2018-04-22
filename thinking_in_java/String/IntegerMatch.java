package com.ostream.ThinkingInJavaII.string;

/**
 * @Create by ostreamBaba on 18-4-22
 * @描述
 */

/*
-?表示可能有-
表示一位数字 \\d
表示一个或者多个数字 \\d+
(-|\\+)?表示字符可能有一个-或者+

*/

public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+123".matches("-?\\d+"));
        System.out.println("+123".matches("(-|\\+)?\\d++"));
    }
}
