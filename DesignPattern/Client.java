package com.ostream.DesignPattern;

/**
 * @ Create by ostreamBaba on 18-5-11
 * @ 简单工厂模式
 */
//这样做能把客户类和具体子类的实现解耦，客户类不再需要知道有哪些子类以及应当实例化哪个子类。
//因为客户类往往有多个，如果不使用简单工厂，所有的客户类都要知道所有子类的细节。而且一旦子类发生改变，例如增加子类，那么所有的客户类都要进行修改。
//如果存在下面这种代码，就需要使用简单工厂将对象实例化的部分放到简单工厂中。
class Product{}
final class CreateP1 extends Product{}
final class CreateP2 extends Product{}
final class CreateP3 extends Product{}

class SimpleFactory{
    public static Product createProduct(int Type){
        if(1==Type){
            return new CreateP1();
        }else if(2==Type){
            return new CreateP2();
        }else {
            return new CreateP3();
        }
    }
}
public class Client {
    public static void main(String[] args) {
        int type=1;
        Product product=SimpleFactory.createProduct(type);
    }
}
