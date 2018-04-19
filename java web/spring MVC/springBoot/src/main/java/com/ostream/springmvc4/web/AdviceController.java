package com.ostream.springmvc4.web;

import com.ostream.springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Create by ostreamBaba on 18-4-10
 * @描述
 */

@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj demoObj){
        throw new IllegalArgumentException("sorry,error/"+"来着@ModelAttribute： "+msg);
    }
}
