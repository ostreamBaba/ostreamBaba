package com.viscu.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ Create by ostreamBaba on 18-5-21
 * @ 描述
 */
@RestController
public class testThymeleaf {
    @RequestMapping("/testT")
    public ModelAndView test(ModelAndView modelAndView){
        modelAndView.setViewName("/greeting");
        modelAndView.addObject("title","fucking");
        return modelAndView;
    }
}
