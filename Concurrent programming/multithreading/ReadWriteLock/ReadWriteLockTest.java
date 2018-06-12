package com.multithreading.ReadWriteLock;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ 描述
 */
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
    ReadWriteLock主要特征：
    公平性： 可以选择锁的获取顺序是否设为公平的 若公平 那么等待时间久的线程将优先获取锁
    可重入性 Reader角色的线程可以获取 用于写入的锁 Writer角色的线程也可以获取 用于读取的锁
    锁降级 用于写入的锁 降级为 用于读取的锁  而 用于读取的锁 不可升级为 用于写入的锁
    便捷方法： 提供了获取等待中的线程的个数的方法getQueueLength以及检查是否获取了用于写入的锁的方法isWriteLocked...

 */

public class ReadWriteLockTest {
}

class Data1{
    private final char[] buffer;
    private final ReadWriteLock lock=new ReentrantReadWriteLock(true); //fair
    private final Lock readLock=lock.readLock();
    private final Lock writeLock=lock.writeLock();

    public Data1(int size) {
        this.buffer=new char[size];
        for (int i = 0; i < size; i++) {
            buffer[i]='*';
        }
    }

    public char[] read() throws InterruptedException{
        readLock.lock();
        try {
            return doRead();
        }finally {
            readLock.unlock();
        }
    }

    public void write(char c) throws InterruptedException{
        writeLock.lock();
        try{
            doWrite(c);
        }finally {
            writeLock.unlock();
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
