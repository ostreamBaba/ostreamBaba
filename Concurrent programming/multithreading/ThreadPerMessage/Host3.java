package com.multithreading.ThreadPerMessage;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ Create by ostreamBaba on 18-6-13
 * @ 描述
 */
public class Host3 {
    private final Helper helper=new Helper();
    private final ScheduledExecutorService scheduledExecutorService;

    public Host3(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
    }

    //调度运行
    //ScheduledExecutorService用于推迟操作的执行
    public void request(final int count, final char c){
        System.out.println(" request("+count+", "+c+") BEING");
        scheduledExecutorService.schedule(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count,c);
                    }
                }, 3L, TimeUnit.SECONDS
        ); //request请求到达约3秒后再执行
        System.out.println(" request("+count+", "+c+") END");
    }
}
