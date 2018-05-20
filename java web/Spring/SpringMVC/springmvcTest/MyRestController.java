package com.viscu.springmvc.springmvcTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Create by ostreamBaba on 18-5-20
 * @ √Ë ˆ
 */

@RestController
public class MyRestController {
    @Autowired
    DemoService demoService;
    @RequestMapping(value = "/testRest",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String testRest(){
        return demoService.hello();
    }
}
