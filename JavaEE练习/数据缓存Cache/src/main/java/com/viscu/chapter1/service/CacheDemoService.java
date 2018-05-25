package com.viscu.chapter1.service;

import com.viscu.chapter1.domain.Person;

/**
 * @ Create by ostreamBaba on 18-5-25
 * @ 描述
 */
public interface CacheDemoService {
    Person save(Person person);
    void remove(Long id);
    Person findOne(Person person);
}
