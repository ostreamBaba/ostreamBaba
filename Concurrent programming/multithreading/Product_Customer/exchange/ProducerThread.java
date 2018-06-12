package com.multithreading.Product_Customer.exchange;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ 描述
 */
public class ProducerThread extends Thread{
    private final Exchanger<char[]> exchanger;
    private final Random random;
    private char[] buffer=null;
    private int index=0;

    public ProducerThread(String name, Exchanger<char[]> exchanger, char[] buffer,long seed) {
        super( name );
        this.buffer = buffer;
        this.exchanger = exchanger;
        this.random = new Random(seed);
    }

    //向缓存区填充字符
    @Override
    public void run() {
        while (true){
            try{
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i]=nextChar();
                    System.out.println(Thread.currentThread().getName()+": "+buffer[i]+" -->");
                }

                //交换字符
                System.out.println(Thread.currentThread().getName()+": EXCHANGE BEING");
                exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName()+": EXCHANGE END");

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //填充字符 直至缓冲区被填满
    //使用exchange方法将填满的缓冲区传递给CustomerThread
    //传递缓冲区之后 作为交换 接受空的缓冲区


    //生产字符
    private char nextChar()throws InterruptedException{
        char c=(char) ('A'+index%26);
        index++;
        Thread.sleep(random.nextInt(1000));
        return c;
    }
}
