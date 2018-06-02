package com.design.FactoryMethod.idcard;

import com.design.FactoryMethod.framework.Factory;
import com.design.FactoryMethod.framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Create by ostreamBaba on 18-6-2
 * @ √Ë ˆ
 */
public class IdCardFactory extends Factory{
    private List owners=new ArrayList();
    @Override
    protected Product createProduct(String owner) {
        return new IdCard(owner);
    }
    @Override
    protected void registerProduct(Product p) {
        owners.add((IdCard)p);
    }
    public List getOwners() {
        return owners;
    }
}
