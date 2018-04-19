package com.jdbc;

import com.jdbc.service.AccountDaoService;
import com.jdbc.service.AccountDaoServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Create by ostreamBaba on 18-4-6
 * @描述
 */
public class AnnotationTest {

    private static final String XMLPATH;
    private static final ApplicationContext APPLICATION_CONTEXT;
    private static final AccountDaoService ACCOUNT_DAO_SERVICE;

    static {
        XMLPATH="/config/jdbc-manager.xml";
        APPLICATION_CONTEXT=new ClassPathXmlApplicationContext(XMLPATH);
        ACCOUNT_DAO_SERVICE=(AccountDaoService) APPLICATION_CONTEXT.getBean("accountService");
    }

    @Test
    public void test(){
        ACCOUNT_DAO_SERVICE.transfer("Tom","Ty",500);
        System.out.println("ok");
    }


}
