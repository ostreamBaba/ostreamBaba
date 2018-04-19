package com.viscu.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @Create by ostreamBaba on 18-3-29
 * @√Ë ˆ
 */
public class PrivilegeInterceptor extends AbstractInterceptor{
    private static final long serialVersionUID=1L;

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext actionContext=actionInvocation.getInvocationContext();
        Object user=actionContext.getSession().get("user");
        if(user!=null){
            return  actionInvocation.invoke();
        }else {
            actionContext.put("msg","please login");
            return Action.LOGIN;
        }
    }
}
