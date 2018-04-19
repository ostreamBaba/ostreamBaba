package com.ostream.chapter3.fortest;

import com.ostream.springBoot.chapter3.fortest.DemoConfig;
import com.ostream.springBoot.chapter3.fortest.TestBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Create by ostreamBaba on 18-4-9
 * @描述
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DemoConfig.class}) //来配置ApplicationContext
@ActiveProfiles("prod")  //声明活动的profile
public class DemoBeanIntegrationTests {

    @Autowired  //注入bean
    private TestBean testBean;

    @Test
    public void test(){
        String expected="from production profile";
        String actual=testBean.getContent();
        Assert.assertEquals(expected,actual);
    }

}
