package com.ostream.effective_java;

import java.sql.Time;
import java.util.Date;

/**
 * @Create by ostreamBaba on 18-5-1
 * @描述
 */

//4. 通过私有构造器强化不可实例化的能力
//这样一个类就不能被子类化 所有的构造器都必须显示或者隐式地调用超类构造器
//这种情况下 子类就没有可访问的超类构造器可调用了
public class UtilityClass {
    //Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError(); //不是必须 可以避免在类的内部调用构造器
    }
}

//5.避免创建不必要的对象
class testYear{
    private int year;
    private testYear(int year){
        this.year=year;
    }
    public static testYear getInstance(int year){
        return new testYear(year);
    }
    public int getYear() {
        return year;
    }
}

class Person{
    private int year;
    private Person(int year) {
        this.year = year;
    }
    //假设
    public boolean isBabyBoomer(){ //每次调用都要创建两个新的实例
        testYear start=testYear.getInstance(2010);
        testYear end=testYear.getInstance(2017);
        return this.year>=start.getYear()&&this.year<=end.getYear();
    }
    public static void main(String[] args) {
        String s1=new String("abcd");//don't do this 创建一个新的实例 但是这个创建对象的动作是不必要的
        String s2="abcd";
        System.out.println(s1+" "+s2);
    }
}

class Person1{
    private int year;
    private Person1(int year) {
        this.year = year;
    }
    private static final testYear START;  //只实例化过一次
    private static final testYear END;
    static {
        START=testYear.getInstance(2010);
        END=testYear.getInstance(2017);
    }
    //isBabyBoomer被频繁调用先提高显著的性能
    //若isBabyBoomer永远没有被调用 那么START域和END域就没必要实例化了(延迟初始化????)
    public boolean isBabyBoomer(){
        return this.year>=START.getYear()&&this.year<=END.getYear();
    }
    public static void main(String[] args) {
        String s1=new String("abcd");//don't do this 创建一个新的实例 但是这个创建对象的动作是不必要的
        String s2="abcd";
        System.out.println(s1+" "+s2);
    }
}

//创建多余对象的新方法(自动装箱)
class AutoBoxing{
    public static void main(String[] args) {
        Long sum=0L;
        //构造了2^31个多余的Long实例
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum+=i;
        }
        System.out.println(sum);
        //要优先使用基本类型而不是装箱基本类型 要当无意识的自动装箱
    }
}

//通过维护自己的对象池来避免创建对象并不是一种好的做法 除非线程池中的对象非常重量级(数据库连接池)
