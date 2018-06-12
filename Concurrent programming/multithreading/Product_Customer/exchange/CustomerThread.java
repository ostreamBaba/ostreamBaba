package com.multithreading.Product_Customer.exchange;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ 描述
 */
public class CustomerThread extends Thread{

    private final Random random;
    private final Exchanger<char[]> exchanger;
    private char[] buffer;

    public CustomerThread(String name, Exchanger<char[]> exchanger, char[] buffer, long seed) {
        super( name );
        this.random = new Random(seed);
        this.exchanger = exchanger;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true){
            try{
                //交换缓存区
                System.out.println(Thread.currentThread().getName()+": EXCHANGE BEING");
                buffer=exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName()+": EXCHANGE END");

                //取出字符
                for (int i = 0; i < buffer.length; i++) {
                    System.out.println(Thread.currentThread().getName()+": --> "+buffer[i]);
                    Thread.sleep(random.nextInt(1000));
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //使用exchange方法将空的缓冲区传递给ProducerThread
    //传递空的缓冲区之后 作为交换 接受填满的缓冲区
    //显示缓冲区中的字符

}
/*
CustomerThread: EXCHANGE BEING
        ProducerThread: A -->  Producer 向Buffer1填充字符串
        ProducerThread: B -->
        ProducerThread: C -->
        ProducerThread: D -->
        ProducerThread: E -->
        ProducerThread: F -->
        ProducerThread: G -->
        ProducerThread: H -->
        ProducerThread: I -->
        ProducerThread: J -->
        ProducerThread: EXCHANGE BEING  进行交换
        ProducerThread: EXCHANGE END
        CustomerThread: EXCHANGE END
        CustomerThread: --> A  CustomerThread依次输出A->J
        ProducerThread: K -->  //继续填充K～T
        ProducerThread: L -->
        CustomerThread: --> L
        CustomerThread: --> C
        ProducerThread: M -->
        CustomerThread: --> D
        ProducerThread: N -->
        CustomerThread: --> E
*/
