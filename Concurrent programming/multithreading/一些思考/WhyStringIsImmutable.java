package com.viscu.something;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ String具有immutable性
 */
public class WhyStringIsImmutable {
    public static void main(String[] args) {
        String string="Bat";
        System.out.println(string.replace('B','C'));//虽然String有replace，
        //可以这里改变不是String底层的char[]数组(底层数组是final实现)
        System.out.println(string);
        //重新打印的依旧是Bat
    }
}
