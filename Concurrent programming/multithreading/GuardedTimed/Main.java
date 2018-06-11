package com.multithreading.GuardedTimed;

import com.mysql.jdbc.TimeUtil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @ Create by ostreamBaba on 18-6-11
 * @ √Ë ˆ
 */
public class Main {
    public static void main(String[] args) {
        Host host=new Host(10000);
        //new NotifyThread("notifyThread",host).start();
        try{
            System.out.println("execute BEING");
            host.execute();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (TimeoutException e){
            e.printStackTrace();
        }
    }
}
