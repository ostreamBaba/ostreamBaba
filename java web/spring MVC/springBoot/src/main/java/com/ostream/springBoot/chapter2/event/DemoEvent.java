package com.ostream.springBoot.chapter2.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Create by ostreamBaba on 18-4-8
 * @描述
 */

//自定义时间
public class DemoEvent extends ApplicationEvent{

    private static final long serialVersionUID=1L;
    private String msg;

    public DemoEvent(Object source,String msg) {
        super( source );
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

