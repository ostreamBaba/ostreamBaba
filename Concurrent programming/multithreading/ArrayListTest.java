package com.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * @ Create by ostreamBaba on 18-6-10
 * @ 描述 ArrayList不是线程安全
 */
public class ArrayListTest {
    public static void main(String[] args) {
        //List<Integer> list=new ArrayList<Integer>();
        //使用Collections.synchronizedList同步ArrayList实例
        //final List<Integer> list= Collections.synchronizedList(new ArrayList<Integer>());
        final List<Integer> list=new CopyOnWriteArrayList<Integer>();
        //写时复制 当对集合执行写的操作时 内部已经确保安全的数组就会被整体复制 复制之后 就无需在使用迭代器以此读取元素的时候担心元素会被修改了
        new WriteThread(list).start();
        new ReadThread(list).start();
    }
}


class WriteThread extends Thread{

    private final List<Integer> list;

    public WriteThread(List<Integer> list) {
        super("writeThread");
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; true; i++) {
            list.add(i);
            list.remove(0);
        }
    }
}

class ReadThread extends Thread{

    private final List<Integer> list;

    public ReadThread(List<Integer> list) {
        super("ReadThread");
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            /*for (int n:list){   //使用ArrayLIst出现异常
                System.out.println(n);
            }*/
            /*synchronized (list){ //使用Collections.synchronizedList需要对迭代器加锁
                for(int n:list){ //这里隐式地使用了迭代器 不加锁会出现异常(可能在读的过程中被修改)
                    System.out.println(n);
                }
            }*/
            for (int n:list){   //使用CopyOnWriteArrayList
                System.out.println(n);
            }
        }
    }
}



/*
class Test {
    public static void main(String[] args)  {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                */
/*list.remove(integer);*//*

                iterator.remove();
        }
    }
}*/
