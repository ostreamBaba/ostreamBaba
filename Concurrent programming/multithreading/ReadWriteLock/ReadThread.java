package com.multithreading.ReadWriteLock;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ ÃèÊö
 */
public class ReadThread extends Thread{
    /*private final Data data;

    public ReadThread(Data data) {
        this.data = data;
    }*/

    private final Data1 data;

    public ReadThread(Data1 data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true){
                char[] buffer=data.read();
                System.out.println(Thread.currentThread().getName()+" reads "+String.valueOf(buffer));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
