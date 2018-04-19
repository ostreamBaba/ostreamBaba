package com.jdbc;

import com.jdbc.Dao.AccountDao;
import com.jdbc.Dao.UserDao;
import com.jdbc.service.AccountDaoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Create by ostreamBaba on 18-4-5
 * @描述
 */
public class managerTest {

    private static final String XMLPATH;
    private static final ApplicationContext APPLICATION_CONTEXT;
    private static final AccountDaoService ACCOUNT_DAO_SERVICE;

    static {
        XMLPATH="/config/jdbc-manager.xml";
        APPLICATION_CONTEXT=new ClassPathXmlApplicationContext(XMLPATH);
        /*ACCOUNT_DAO_SERVICE=(AccountDaoService) APPLICATION_CONTEXT.getBean("accountServiceProxy");*/
        ACCOUNT_DAO_SERVICE=(AccountDaoService) APPLICATION_CONTEXT.getBean("accountService");
    }

    //tx/AOP没有执行回滚

    @Test
    public void test(){
        ACCOUNT_DAO_SERVICE.transfer("Tom","Ty",1000);
        System.out.println("ok");
    }


}
