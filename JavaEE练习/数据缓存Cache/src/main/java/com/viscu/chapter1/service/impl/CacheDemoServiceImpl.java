package com.viscu.chapter1.service.impl;

import com.viscu.chapter1.dao.PersonRepository;
import com.viscu.chapter1.domain.Person;
import com.viscu.chapter1.service.CacheDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ Create by ostreamBaba on 18-5-25
 * @ 描述
 */

@Service
public class CacheDemoServiceImpl implements CacheDemoService{
    @Autowired
    private PersonRepository personRepository;

    @Override
    @CachePut(value = "people",key = "#person.id")
    public Person save(Person person) {
        Person p=this.personRepository.save(person);
        System.out.println("for id,key is: "+p.getId()+" do cache");
        return p;
    }

    //刪除緩存爲people中key爲id的緩存
    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {
        System.out.println("delete id,key is: "+id+" do cache");
        /*this.personRepository.deleteById(id);*/ //1.5.10以上可用
        //this.personRepository.delete(id);
    }

    @Override
    @Cacheable(value = "people",key = "#person.id")
    public Person findOne(Person person) {
        /*Person p=this.personRepository.findById(person.getId()).get();*/
        Person p=this.personRepository.findOne(person.getId());
        System.out.println("for id,key is: "+person.getId()+" do cache");
        return p;
    }
}
