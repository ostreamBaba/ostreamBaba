package com.viscu.chapter1.controller;

import com.viscu.chapter1.domain.Person;
import com.viscu.chapter1.service.CacheDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Create by ostreamBaba on 18-5-25
 * @ 描述
 */

@RestController
public class CacheController {
    @Autowired
    private CacheDemoService cacheDemoService;


    @RequestMapping("/put")
    public Person put(Person person){
        return this.cacheDemoService.save(person);
    }

    @RequestMapping("/able")
    public Person findOne(Person person){
        return this.cacheDemoService.findOne(person);
    }


    @RequestMapping("/evit")
    public void evit(Long id){
        this.cacheDemoService.remove(id);
    }

}
