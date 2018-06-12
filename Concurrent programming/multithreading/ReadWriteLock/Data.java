package com.multithreading.ReadWriteLock;

import java.util.Arrays;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ 执行读写操作的类
 */
public class Data {
    private final char[] buffer;
    private final ReadWriteLock lock=new ReadWriteLock();

    public Data(int size) {
        this.buffer=new char[size];
        for (int i = 0; i < size; i++) {
            buffer[i]='*';
        }
    }

    public char[] read() throws InterruptedException{
        lock.readLock();
        try {
            return doRead();
        }finally {
            lock.readUnlock();
        }
    }

    public void write(char c) throws InterruptedException{
        lock.writeLock();
        try{
            doWrite(c);
        }finally {
            lock.writeUnlock();
        }
    }

    private char[] doRead() {
        char[] newBuffer= Arrays.copyOf(buffer,buffer.length);//复制数组
        slowly();
        return newBuffer;
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i]=c;
            slowly();
        }
    }

    private void slowly(){
        try{
            Thread.sleep(50);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
