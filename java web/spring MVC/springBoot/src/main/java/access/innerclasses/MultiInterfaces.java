package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */

//多重继承

interface A{}
interface B{}
class X implements A,B{}
class Y implements A{
    B makeB(){
        return new B(){};//匿名内部类
    }
}
//接口可以用单一类和内部类
public class MultiInterfaces {
    static void tasksA(A a){}
    static void tasksB(B b){}

    public static void main(String[] args) {
        X x=new X();
        Y y=new Y();
        MultiInterfaces.tasksA(x);
        MultiInterfaces.tasksB(x);
        MultiInterfaces.tasksA(y);
        MultiInterfaces.tasksB(y.makeB());
    }
}


