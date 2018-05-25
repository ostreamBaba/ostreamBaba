package com.viscu.chapter1.controller;

import com.viscu.chapter1.domain.Person;
import com.viscu.chapter1.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Create by ostreamBaba on 18-5-25
 * @ 描述
 */

@RestController
public class TranscationController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/rollback")
    public Person rollback(Person person){
        return demoService.savePersonWithRollBack(person);
    }

    @RequestMapping("/norollback")
    public Person noRollback(Person person){
        return demoService.savePersonWithoutRollBack(person);
    }

}
