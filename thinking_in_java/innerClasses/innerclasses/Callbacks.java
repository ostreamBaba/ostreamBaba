package access.innerclasses;

/**
 * @Create by ostreamBaba on 18-4-19
 * @描述
 */


interface Incrementable{
    void increment();
}
//外围类实现接口
class Calleel implements Incrementable{
    private int i=0;
    @Override
    public void increment() {
        ++i;
        System.out.println(i);
    }
}

class MyIncrement{
    public void increment(){
        System.out.println("other");
    }
    static void f(MyIncrement mi){
        mi.increment();
    }
}
//既继承MyIncrement类又实现increment接口 并且都有increment()方法而且完全不相关 使用内部类可以方法独立实现
class Calleell extends MyIncrement{
    private int i=0;
    @Override
    public void increment() {
        super.increment();
        ++i;
        System.out.println(i);
    }
    private class Closure implements Incrementable{
        @Override
        public void increment() {
            Calleell.this.increment();
        }
    }
    Incrementable getCallBackReference(){
        return new Closure();
    }
}

class Caller{
    private Incrementable callbackReference;
    public Caller(Incrementable callbackReference) {
        this.callbackReference = callbackReference;
    }
    void go(){
        callbackReference.increment();
    }
}

//闭包与回调 内部类是面向对象的闭包
public class Callbacks {
    public static void main(String[] args) {
        Calleel c1=new Calleel();
        Calleell c2=new Calleell();
        MyIncrement.f(c2);
        Caller caller1=new Caller(c1);
        Caller caller2=new Caller(c2.getCallBackReference());//回调
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
