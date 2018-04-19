package com.annotation.action;

import com.annotation.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @Create by ostreamBaba on 18-4-3
 * @描述
 */

@Controller("userAction")
public class UserAction {

    @Resource
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void save(){
        this.userService.save();
        System.out.println("userAction...save...");
    }
}
