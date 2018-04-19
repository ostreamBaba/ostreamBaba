package com.viscu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.viscu.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.xml.ws.Action;

/**
 * @Create by ostreamBaba on 18-3-29
 * @√Ë ˆ
 */

@Controller("loginAction")
@Scope("protoType")
public class LoginAction extends ActionSupport implements ModelDriven<User>{

    private static final long serivalVersion=1L;
    private User user=new User();
    public User getModel(){
        return user;
    }

    @Override
    public String execute() throws Exception {
        ActionContext actionContext=ActionContext.getContext();
        if("admin".equals(user.getUsername())&&"admin".equals(user.getPassword())){
            actionContext.getSession().put("user",user);
            return SUCCESS;
        }else{
            actionContext.put("msg","failed to login");
            return INPUT;
        }
    }
}
