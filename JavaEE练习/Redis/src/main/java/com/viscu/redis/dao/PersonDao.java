package com.viscu.redis.dao;

import com.viscu.redis.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @ Create by ostreamBaba on 18-5-26
 * @ 描述
 */

@Repository
public class PersonDao {

    //@Autowired
    //StringRedisTemplate stringRedisTemplate;  //SpringBoot已经为我们配置了StringRedisTemplate 直接注入

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr; //使用@Resource注入指定stringRedisTemplate 可注入基于字符串的简单属性的操作方法

    //@Autowired
    //RedisTemplate<Object, Object> redisTemplate; //注入RedisTemplate

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOps;//注入基于对象操作的简单属性的操作方法

    public void StringRedisTemplateDemo() {
        valOpsStr.set( "xx", "yy" );
    }

    public void save(Person person) {
        valOps.set(person.getId(),person);
    }

    public String getString(){
        return valOpsStr.get("xx");
    }

    public Person getPerson(){
        return (Person)valOps.get("1");
    }

}
