package com.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.entity.User;
import com.ssh.service.UserService;

/**
 * @Create by ostreamBaba on 18-4-6
 * @描述
 */

//struts2和spring整合

public class UserAction extends ActionSupport implements ModelDriven<User>{

    private User user=new User();
    private UserService userService;

    @Override
    public User getModel() {
        return this.user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String add(){
        this.userService.saveUser(user);
        return SUCCESS;
    }
}
