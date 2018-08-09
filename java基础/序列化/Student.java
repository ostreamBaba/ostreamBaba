package com.ThinkingInJava.util.序列化;

import java.io.ObjectStreamClass;
import java.io.Serializable;

/**
 * @ Create by ostreamBaba on 18-8-9
 * @ 描述
 */

//很多时候，类定义的改变势在必行，但又不希望出现序列化的不兼容性。我们就可以通过在类中显示的定义serialVersionUID，
// 并赋予一个明确的long值即可。这样会逃过JVM的默认兼容性检查。但是如果数据域名的改变会导致反序列化后，
// 改变的数据域只能得到默认的null或者0或者false值。

public class Student implements Serializable{
    //private static final long serialVersionUID = 2169561812859380129L;
    private String name;//修改前
    //private String name1;修改后

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        long sUID= ObjectStreamClass.lookup(Class.forName("com.ThinkingInJava.util.序列化.Student")).getSerialVersionUID();
        System.out.println(sUID);
    }
}
