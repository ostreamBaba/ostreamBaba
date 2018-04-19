package com.viscu.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Create by ostreamBaba on 18-4-3
 * @描述
 */
public class MyAction extends ActionSupport{
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String execute() throws Exception {
        number+=10;
        return SUCCESS;
    }
}