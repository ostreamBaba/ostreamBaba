package com.viscu.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.viscu.entity.Product;

/**
 * @Create by ostreamBaba on 18-3-29
 * @ÃèÊö
 */

//Ä£ÐÍÇý¶¯
public class ValueStack2Action extends ActionSupport implements ModelDriven<Product> {

    private Product p3=new Product();

    @Override
    public Product getModel() {
        return p3;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
