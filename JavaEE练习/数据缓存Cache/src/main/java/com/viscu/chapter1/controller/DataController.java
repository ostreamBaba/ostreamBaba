package com.viscu.chapter1.controller;

import com.viscu.chapter1.dao.PersonRepository;
import com.viscu.chapter1.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sang on 2016/12/30.
 */
@RestController
public class DataController {
    //Spring Date JPA 已自动为你注册了bean 所以可以自动注入
    @Autowired
    PersonRepository personRepository;
    @RequestMapping("/save")
    public Person save(String name, String address, Integer age) {
        Person person = personRepository.save(new Person(null, name, age, address));
        return person;
    }
    @RequestMapping("/q1")
    public List<Person> q1(String address) {
        List<Person> people = personRepository.findByAddress(address);
        return people;
    }
    @RequestMapping("/q2")
    public Person q2(String name, String address) {
        Person people = personRepository.findByNameAndAddress(name, address);
        return people;
    }
    @RequestMapping("/q3")
    public Person q3(String name, String address) {
        Person person = personRepository.withNameAndAddressQuery(name, address);
        return person;
    }
    @RequestMapping("/q4")
    public Person q4(String name, String address) {
        Person person = personRepository.withNameAndAddressNamedQuery(name, address);
        return person;
    }
    @RequestMapping("/sort")
    public List<Person> sort() {
        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
        return people;
    }
    /*@RequestMapping("/page")
    public Page<Person> page(int page,int size){
        Page<Person> all = personRepository.findAll(new PageRequest(page, size));
        return all;
    }*/
    @RequestMapping("/all")
    public List<Person> all(){
        return personRepository.findAll();
    }
    //模糊查询
    @RequestMapping("/auto")
    public Page<Person> auto(Person person){
        Page<Person> pagePeople=personRepository.findByAuto(person,new PageRequest(0,10));
        return pagePeople;
    }
}
//控制器接受一个Person查询对象 当person对象时 当Person的name有值时 会对name进行like查询
//当age有值的时候会进行等于查询 当Person有对个值不为空的时候 会自动构造多个查询条件 当Person所有值为空的时候 默认查询出所有记录
//在实体类中定义的数据类型要用包装类型 在SpringMVC中 使用原始数据类型会自动初始化为0 而不是空 导致我们构造条件失败
