package com.ostream.springBoot.chapter1.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */

@Service("useFuntionService")
public class UseFuntionService {

    @Autowired
    private FuntionService funtionService;

    public String say(String name){
        return funtionService.say(name);
    }
}
