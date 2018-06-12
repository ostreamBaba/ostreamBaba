package com.multithreading.ReadWriteLock;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ 描述
 */

// 安全性： 两种冲突
// 读取 和 写入 的冲突
// 写入 和 写入 的冲突(读读不存在冲突)

/*
   当线程获取读的锁的时候 有线程执行写操作 则等待(不然发生read-write conflict);有线程执行读操作 无需等待
   当线程获取读的锁的时候 其他线程无论什么操作 都等待

 */


/*
    优点：利用 读取操作 的线程之间不会冲突的特性来提高程序性能
    适合读取频率比较繁重时(耗费时间)
    适合读取频率比写入频率高时(但写入频率比较高的话 writer角色会频繁停止对reader角色的处理 就无法体现Read-Write Lock的优点了)
 */

public final class ReadWriteLock {
    private int readingReaders=0; //实际正在读取中的线程个数
    private int waitingWriters=0; //正在等待写入的线程个数
    private int writingWriters=0; //实际正在写入中的线程个数

    private boolean preferWriter=true;//若写入优先 则为true

    /*设置preferWriter字段的原因：
        多个线程读取不冲突
        当时有线程进行读取操作时 那么写线程进入休眠
        当读线程释放锁 大量(读、写)线程竞争锁 如果读线程获得锁 那么就进入休眠 如果写线程获得锁 那么进行写入操作(这样进形成了进行完读操作 优先进行写操作)
    */

    //synchronized可以用于获取实例的锁(每隔实例都拥有一个锁 但是同一个锁不可以由两个以上的线程同时获取 --> 物理锁)
    //ReadWriteLock类实现了 用于读取的锁 和 用于写入的锁 两个逻辑锁(开发人员自己实现的) 但实现这两个逻辑锁的物理锁只有一个 那就是ReadWriteLock实例的锁


    public synchronized void readLock() throws InterruptedException{  //某线程获得读的锁
        while (writingWriters>0||(preferWriter&&waitingWriters>0)){  //当有线程正在写入的 则等待
            wait();
        }
        ++readingReaders; //实际正在读取的线程加1    //若没有线程在写入 则可以读
    }

    public synchronized void readUnlock(){  //某线程释放锁
        --readingReaders;   //正在读取的线程的数量-1
        preferWriter=true;  //read操作后优先执行write操作
        notifyAll(); //唤醒所有在等待的写 线程
    }

    public synchronized void writeLock() throws InterruptedException{ //某线程获得写的锁
        ++waitingWriters; //正在等待写入的线程加1
        try{
            while (readingReaders>0||writingWriters>0){  //若有线程正在读取或者写入 那么该写线程 等待
                wait();
            }
        }finally {  //或没有线程正在读取或者写入 那么执行该写线程
            --waitingWriters; //正在等待写入的线程线程个数减1
        }
        ++writingWriters; //实际正在写入的线程个数加1
    }

    public synchronized void writeUnlock(){  //某线程释放锁
        --writingWriters; //实际正在写入的线程减1
        preferWriter=false;
        notifyAll(); //唤醒所有的写线程 和 读线程
    }
}
