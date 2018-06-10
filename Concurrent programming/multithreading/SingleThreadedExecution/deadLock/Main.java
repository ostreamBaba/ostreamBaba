package com.multithreading.SingleThreadedExecution.deadLock;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ ÃèÊö
 */
public class Main {
    public static void main(String[] args) {
        Tool span=new Tool("span");
        Tool fork=new Tool("fork");

        new EaterThread("a",span,fork).start();
        new EaterThread("b",fork,span).start();
    }
}

