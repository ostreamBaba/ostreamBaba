package com.multithreading.ReadWriteLock;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ ÃèÊö
 */
public class Main {
    public static void main(String[] args) {
        Data1 data=new Data1(10);
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new WriteThread(data,"ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
        new WriteThread(data,"abcdefghijklmnopqrstuvwxyz").start();
    }
}
