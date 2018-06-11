package com.multithreading.GuardedTimed;

import java.util.concurrent.TimeUnit;

/**
 * @ Create by ostreamBaba on 18-6-11
 * @ √Ë ˆ
 */
public class NotifyThread extends Thread{
    private final Host host;

    public NotifyThread(String name,Host host) {
        super(name);
        this.host = host;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
            host.setExecutable(true);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
