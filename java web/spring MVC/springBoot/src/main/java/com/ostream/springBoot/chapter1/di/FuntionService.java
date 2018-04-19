package com.ostream.springBoot.chapter1.di;

import org.springframework.stereotype.Service;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */

@Service("funtionService")
public class FuntionService {

    public String say(String name){
        return "f**k "+name;
    }

}
