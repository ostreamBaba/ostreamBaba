package com.multithreading.ThreadPerMessage.test;

/**
 * @ Create by ostreamBaba on 18-6-13
 * @ √Ë ˆ
 */
public class Service {
    public static void service(){
        new Thread(){
            @Override
            public void run() {
                doService();
            }
        }.start();

    }

    private static void doService(){
        System.out.println("service");
        for (int i = 0; i < 50; i++) {
            System.out.println(".");
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("done.");
    }

}
