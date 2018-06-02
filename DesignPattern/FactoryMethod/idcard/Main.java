package com.design.FactoryMethod.idcard;

import com.design.FactoryMethod.framework.Factory;
import com.design.FactoryMethod.framework.Product;

/**
 * @ Create by ostreamBaba on 18-6-2
 * @ √Ë ˆ
 */
public class Main {
    public static void main(String[] args) {
        Factory factory=new IdCardFactory();
        Product p1=factory.create("1");
        Product p2=factory.create("2");
        Product P3=factory.create("3");
        p1.use();
        p2.use();
        P3.use();
    }
}
