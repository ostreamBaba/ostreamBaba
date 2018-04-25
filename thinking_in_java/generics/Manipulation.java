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
//可在这里并没有什么用处
class Manipulator<T extends HasF> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f();
    }
}

//向上转型
class Manipulator1{
    private HasF hasF;
    public Manipulator1(HasF hasF) {
        this.hasF = hasF;
    }
    public void manipulate() {
        hasF.f();
    }

    public HasF getHasF() {
        return hasF;
    }
}

//返回确切类型
class Manipulator2<T extends HasF>{
    private T obj;

    public Manipulator2(T obj) {
        this.obj = obj;
    }

    public T get(){
        return obj;
    }
}


class hasf extends HasF{}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf=new HasF();
        Manipulator<HasF> manipulator=new Manipulator<HasF>(hf);
        manipulator.manipulate();
        hasf hasf=new hasf();
        Manipulator1 manipulator1=new Manipulator1(hasf);
        Manipulator2<hasf> manipulator2=new Manipulator2(hasf);
        hasf hasf1=(hasf) manipulator1.getHasF();
        hasf hasf2=manipulator2.get();

    }
}
