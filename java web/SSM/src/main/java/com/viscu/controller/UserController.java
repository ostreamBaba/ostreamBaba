package com.viscu.controller;

import com.viscu.model.User;
import com.viscu.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ Create by ostreamBaba on 18-5-23
 * @ √Ë ˆ
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDaoService userDaoService;

    @RequestMapping(value = "/findUser")
    @ResponseBody
    public String getUser(){
        User user=this.userDaoService.findUserById(1);
        System.out.println(user.getName());
        return user.getPassword();
    }

}
