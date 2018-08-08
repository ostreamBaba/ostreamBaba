package com.example.demo;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * @ Create by ostreamBaba on 18-6-27
 * @ 自动建表 设置为utf-8
 */

public class MySQL5DialectUTF8 extends MySQL5Dialect {
    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
