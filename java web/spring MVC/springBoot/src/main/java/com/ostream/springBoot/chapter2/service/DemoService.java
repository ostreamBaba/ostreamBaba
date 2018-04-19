package com.ostream.springBoot.chapter2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */
@Service
public class DemoService {

    @Value("其他类的属性")
    private String another;

    public void setAnother(String another) {
        this.another = another;
    }

    public String getAnother() {
        return another;
    }
}
