package com.viscu.chapter1.service.impl;

import com.viscu.chapter1.dao.PersonRepository;
import com.viscu.chapter1.domain.Person;
import com.viscu.chapter1.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ Create by ostreamBaba on 18-5-25
 * @ 事务支持
 */


@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    PersonRepository repository;

    @Transactional(rollbackFor = {IllegalArgumentException.class}) //回滚
    @Override
    public Person savePersonWithRollBack(Person person) {
        Person p=repository.save(person);
        if(person.getName().equals("ee")){
            throw new IllegalArgumentException("ee is exist, rollback");
        }
        return p;
    }

    @Transactional(noRollbackFor = {IllegalArgumentException.class}) //不回滚
    @Override
    public Person savePersonWithoutRollBack(Person person) {
        Person p=repository.save(person);
        if(person.getName().equals("ee")){
            throw new IllegalArgumentException("ee is exist, norollback");
        }
        return p;
    }
}
