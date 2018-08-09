package com.ThinkingInJava.util.序列化;

import java.io.*;

/**
 * @ Create by ostreamBaba on 18-8-9
 * @ 描述
 */

//可序列化的类成功序列化之后，是不是一定可以反序列化呢？

//父类对象不能序列化
class Person{
    private String name;
    public Person(String name) {
        this.name = name;
    }

    public Person() { } //加个无参构造器

    public String getName() {
        return name;
    }
}
//子类对象可以序列化
//如果当前类的所有超类中有一个类即不能序列化，也没有无参构造器。那么当前类将不能反序列化。
//如果有无参构造器，那么此超类反序列化的数据域将会是null或者0，false等等。
public class Boy extends Person implements Serializable {
    private static final long serialVersionUID = -4005201724915326804L;
    private int id;
    public Boy(String name,int id) {
        super(name);
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化
        File file=new File("test2.txt");
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(new Boy("lil",18));
        out.flush();
        out.close();

        //反序列化
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(file));
        Boy boy= (Boy) in.readObject();
        in.close();
        System.out.println(boy.getId());
    }
}
