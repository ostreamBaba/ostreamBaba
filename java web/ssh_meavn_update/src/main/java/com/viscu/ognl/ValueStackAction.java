package com.viscu.ognl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @Create by ostreamBaba on 18-3-29
 * @√Ë ˆ
 */
public class ValueStackAction extends ActionSupport{
    @Override
    public String execute() throws Exception {
        ValueStack valueStack= ActionContext.getContext().getValueStack();
        System.out.println(valueStack);
        return SUCCESS;
    }
}
