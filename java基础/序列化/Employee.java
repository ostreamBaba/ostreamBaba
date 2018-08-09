package com.ThinkingInJava.util.序列化;

import java.io.*;
import java.util.zip.ZipFile;

/**
 * @ Create by ostreamBaba on 18-8-8
 * @ 包含了不可序列化的对象域的对象也是不能序列化的。
 */
public class Employee implements Serializable {

    private static final long serialVersionUID = -858657284703348618L;

    private ZipFile zf=null; //不可序列化

    public Employee(ZipFile zf) {
        this.zf = zf;
    }

    public static void main(String[] args) throws IOException {
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File("test1.txt")));
        out.writeObject(new Employee(new ZipFile("/home/ios666/Desktop/1.zip")));
    }
}
