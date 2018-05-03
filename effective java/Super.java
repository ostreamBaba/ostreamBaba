package com.ostream.effective_java.classes;

import java.util.Date;

/**
 * @Create by ostreamBaba on 18-5-3
 * @描述
 */

//不能在构造器中直接或者间接地调用可被覆盖的方法
//
public class Super {
    public Super() {
        overrideMe();
    }
    public void overrideMe(){ }
}
final class Sub extends Super{
    private final Date date;
    Sub(){
        date=new Date();
    }
    @Override
    public void overrideMe() {
        //date.getYear(); 抛出空指针异常
        System.out.println(date);
    }
    public static void main(String[] args) {
        Sub sub=new Sub();
        sub.overrideMe();
    }
}
