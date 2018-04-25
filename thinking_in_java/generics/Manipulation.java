package com.ostream.ThinkingInJavaII.generics;

/**
 * @Create by ostreamBaba on 18-4-25
 * @描述
 */

class HasF{
    public void f(){
        System.out.println("hasf.f()");
    }
}

//C++支持 java不支持
/*class Manipulator<T>{
    private T obj;
    public Manipulator(T obj) {
        this.obj = obj;
    }
    public void manipulate(){
        obj.f();
    }
}*/

//边界<T extends HasF>声明T必须具有类型HasF或者从HasF导出的类型
class Manipulator<T extends HasF> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f();
    }
}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf=new HasF();
        Manipulator<HasF> manipulator=new Manipulator<HasF>(hf);
        manipulator.manipulate();
    }
}
