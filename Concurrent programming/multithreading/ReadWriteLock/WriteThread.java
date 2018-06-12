package com.multithreading.ReadWriteLock;

import java.util.Random;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ √Ë ˆ
 */
public class WriteThread extends Thread{
    private final static Random RANDOM=new Random();
    //private final Data data;
    private final String filler;
    private int index=0;

    private final Data1 data;

    /*public WriteThread(Data data, String filler) {
        this.data = data;
        this.filler = filler;
    }*/
    public WriteThread(Data1 data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        try{
            while (true){
                char c=nextChar();
                data.write(c);
                Thread.sleep(RANDOM.nextInt(3000));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private char nextChar(){
        char c=filler.charAt(index);
        ++index;
        index=index%filler.length();
        return c;
    }
}
