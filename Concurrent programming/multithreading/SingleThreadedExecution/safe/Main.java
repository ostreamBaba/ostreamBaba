package com.multithreading.SingleThreadedExecution.safe;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ ÃèÊö
 */
public class Main {
    public static void main(String[] args) {
        Gate gate=new Gate();
        new UserThread(gate,"A","A").start();
        new UserThread(gate,"B","B").start();
        new UserThread(gate,"C","C").start();
    }
}
