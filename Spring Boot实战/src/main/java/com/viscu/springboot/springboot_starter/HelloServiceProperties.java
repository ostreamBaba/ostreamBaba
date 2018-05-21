package com.viscu.springboot.springboot_starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ Create by ostreamBaba on 18-5-21
 * @ 属性配置
 * @ 类型安全的属性获取 在application.properties中通过hello.msg=来设置 不设置默认hello.msg=world
 */

@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    private static final String MSG="world";
    private String msg=MSG;
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
