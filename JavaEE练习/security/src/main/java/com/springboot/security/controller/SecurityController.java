package com.springboot.security.controller;

import com.springboot.security.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Create by ostreamBaba on 18-5-26
 * @ 描述
 */


@Controller
public class SecurityController {

    @RequestMapping("/")
    public String index(Model model){
        Msg msg=new Msg("测试标题","测试内容","额外信息,只对管理员可见");
        model.addAttribute("msg",msg);
        return "index";
    }

}
