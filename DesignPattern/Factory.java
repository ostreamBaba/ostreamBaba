package com.ostream.DesignPattern;

/**
 * @ Create by ostreamBaba on 18-5-11
 * @ 工厂模式
 */

//定义了一个创建对象的接口，但由子类决定要实例化哪个类。工厂方法把实例化推迟到子类。
public abstract class Factory{
    abstract protected Product FactoryMethod();
    protected void doSomething(){
        Product product=FactoryMethod();
        System.out.println(product);
    }
}
final class CreatePu1 extends Factory{
    private static class ConcreateP1 implements Product{ }
    @Override
    public Product FactoryMethod() {
        return new ConcreateP1();
    }
}
final class CreatePu2 extends Factory{
    private static class ConcreateP2 implements Product{ }
    @Override
    public Product FactoryMethod() {
        return new ConcreateP2();
    }
}
final class CreatePu3 extends Factory{
    private static class ConcreateP3 implements Product{ }
    @Override
    public Product FactoryMethod() {
        return new ConcreateP3();
    }
}

class test{
    public static void main(String[] args) {
        CreatePu1 createPu1=new CreatePu1();
        createPu1.doSomething();
        CreatePu2 createPu2=new CreatePu2();
        createPu2.doSomething();
        CreatePu3 createPu3=new CreatePu3();
        createPu3.doSomething();
    }
}
