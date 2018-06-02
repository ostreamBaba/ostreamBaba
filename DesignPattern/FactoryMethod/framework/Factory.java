package com.design.FactoryMethod.framework;

/**
 * @ Create by ostreamBaba on 18-6-2
 * @ √Ë ˆ
 */
public abstract class Factory {
    public final Product create(String owner){
        Product p=createProduct(owner);
        registerProduct(p);
        return p;
    }
    protected abstract void registerProduct(Product p);
    protected abstract Product createProduct(String owner);
}
