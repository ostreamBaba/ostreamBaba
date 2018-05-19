package com.viscu.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Create by ostreamBaba on 18-5-19
 * @ 描述
 */

@Controller //Spring MVC控制器Bean只能用@Controller 普通bean随意
public class HelloController {

    @RequestMapping("/index") //利用RequestMapping配置url和方法间的映射 支持Servlet的request和response作为参数
    public String hello(){
        return "hello";
    }

}
