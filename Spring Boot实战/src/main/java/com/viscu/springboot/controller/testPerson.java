package com.viscu.springboot.controller;

import com.viscu.springboot.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Create by ostreamBaba on 18-5-21
 * @ 描述
 */

@Controller
public class testPerson {

    @RequestMapping("/testPerson")
    public String index(Model model){
        Person single=new Person("ostreambaba",21);
        List<Person> people=new ArrayList<Person>();
        Person p1=new Person("xx",11);
        Person p2=new Person("yy",22);
        Person p3=new Person("zz",33);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("people",people);
        model.addAttribute("singlePerson",single);
        return "greeting";
    }

}
