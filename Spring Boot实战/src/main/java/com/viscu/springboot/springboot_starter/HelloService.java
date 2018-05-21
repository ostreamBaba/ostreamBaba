package com.viscu.springboot.springboot_starter;

import org.springframework.stereotype.Component;

/**
 * @ Create by ostreamBaba on 18-5-21
 * @ 判断依据类
 * @ 根据此类的存在与否是否来创建这个类的Bean
 */
public class HelloService {
    private String msg;
    public String sayHello(){
        return "hello "+msg;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
