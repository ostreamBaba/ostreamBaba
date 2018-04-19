package com.viscu.action;

import com.opensymphony.xwork2.ActionSupport;
import com.viscu.entity.Product;

/**
 * @Create by ostreamBaba on 18-3-29
 * @√Ë ˆ
 */


// Ù–‘«˝∂Ø ÷µ’ª
public class ValueStackAction extends ActionSupport{

    private Product p3;

    public Product getP3() {
        return p3;
    }

    public void setP3(Product p3) {
        this.p3 = p3;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
