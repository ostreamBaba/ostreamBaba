package com.manytomany.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @Create by ostreamBaba on 18-3-31
 * @描述
 */
public class HibernateUtils {

    private static final Configuration CONFIGURATION;
    private static final SessionFactory SESSION_FACTORY;

    static {
        CONFIGURATION=new Configuration().configure();
        SESSION_FACTORY=CONFIGURATION.buildSessionFactory();
    }

    public static Session getSession(){
        return SESSION_FACTORY.openSession();
    }

}
