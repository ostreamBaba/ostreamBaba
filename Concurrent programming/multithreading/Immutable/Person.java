package com.multithreading.Immutable;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ 创建实例后 状态无法改变
 */
public final class Person {
    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "[Person:name="+name+", address="+address+"]";
    }
}



class test{
    public static void main(String[] args) {
        String str="123";
        StringBuffer sb1=new StringBuffer(str);
        String str2=new String(sb1);
        System.out.println(str2);
        //String和StringBuffer是成对的 且可以相互转换(StringBuffer了解)
    }
}


//成对的mutable类和immutable类 -- StringBuffer和String
//类库中用到immutable模式的有 String BigInteger(BigDecimal)
//正则表达式模式的Pattern 包装类型(装箱类型) java.awt.Color(java.awt.Point不是immutable模式)
