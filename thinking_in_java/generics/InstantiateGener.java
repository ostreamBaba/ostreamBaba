package com.ostream.ThinkingInJavaII.generics;

/**
 * @Create by ostreamBaba on 18-4-25
 * @描述
 */

//java 不能new T() 1.擦除 2.编译器不能验证T是否具有无参数构造器
class ClassAsFactory<T> {
    private T x;
    public ClassAsFactory(Class<T> type) {
        try {
            x=type.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public T getX() {
        return x;
    }
}

class Employee{}

public class InstantiateGener{
    public static void main(String[] args) {
        ClassAsFactory<Employee> classAsFactory=new ClassAsFactory<Employee>(Employee.class);
        System.out.println(classAsFactory);
        //Integer不具备有无参构造器
        try {
            ClassAsFactory<Integer> classAsFactory1=new ClassAsFactory<Integer>(Integer.class);
        }catch (Exception e){
            System.out.println("fail");
        }
    }
    
}
