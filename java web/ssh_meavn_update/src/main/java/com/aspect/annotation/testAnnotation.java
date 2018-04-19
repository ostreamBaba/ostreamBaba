package com.aspect.annotation;

import com.aspect.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Create by ostreamBaba on 18-4-5
 * @描述
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        "classpath:/config/aspectj-annotation.xml")
public class testAnnotation {

    @Resource
    private UserDao userDao;

    @Test
    public void test(){
        userDao.save();
    }

}
