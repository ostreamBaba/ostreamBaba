package com.ostream.ThinkingInJavaII.generics;

/**
 * @Create by ostreamBaba on 18-4-25
 * @描述
 */


class Building{}
class House extends Building{}
public class ClassTypeCapture<T>{
    private Class<T> kind;
    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }
    //引入类型标签 可以匹配泛型参数
    public boolean f(Object arg){
        return kind.isInstance(arg);
    }
    public static void main(String[] args) {
        ClassTypeCapture<Building> classTypeCapture=new ClassTypeCapture<Building>(Building.class);
        System.out.println(classTypeCapture.f(new Building()));
        System.out.println(classTypeCapture.f(new House()));
        ClassTypeCapture<House> classTypeCapture1=new ClassTypeCapture<House>(House.class);
        System.out.println(classTypeCapture1.f(new Building()));
        System.out.println(classTypeCapture1.f(new House()));
    }
}
