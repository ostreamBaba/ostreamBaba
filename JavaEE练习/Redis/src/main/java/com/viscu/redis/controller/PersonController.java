package com.viscu.redis.controller;

import com.viscu.redis.dao.PersonDao;
import com.viscu.redis.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Create by ostreamBaba on 18-5-26
 * @ 描述
 */

@RestController
public class PersonController {

    @Autowired
    PersonDao personDao;

    @RequestMapping("/set")
    public void set(){
        Person person=new Person("2","ostreambaba",18);
        this.personDao.save(person);
        this.personDao.StringRedisTemplateDemo();
    }

    @RequestMapping("/getStr")
    public String getStr(){
        return this.personDao.getString();
    }

    @RequestMapping("/getPerson")
    public Person getPerson(){
        return this.personDao.getPerson();
    }

}
