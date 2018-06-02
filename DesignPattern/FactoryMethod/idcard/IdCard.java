package com.design.FactoryMethod.idcard;

import com.design.FactoryMethod.framework.Product;

/**
 * @ Create by ostreamBaba on 18-6-2
 * @ 描述
 */
public class IdCard extends Product{

    private String owner;

    public IdCard(String owner) {
        System.out.println("制作"+owner+"的ID卡");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用"+owner+"的ID卡");
    }

    public String getOwner() {
        return owner;
    }
}
