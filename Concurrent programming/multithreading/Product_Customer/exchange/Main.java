package com.multithreading.Product_Customer.exchange;

import java.util.concurrent.Exchanger;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ Exchanger用于两个线程安全地交换对象
 */
public class Main {
    public static void main(String[] args) {
        Exchanger<char[]> exchanger=new Exchanger<char[]>();
        char[] buffer1=new char[10];
        char[] buffer2=new char[10];
        new ProducerThread("ProducerThread",exchanger,buffer1,31231).start();
        new CustomerThread("CustomerThread",exchanger,buffer2,61231).start();
    }
}
