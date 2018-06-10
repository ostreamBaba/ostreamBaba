package com.multithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ 描述 ArrayList不是线程安全
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
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
            //list.remove(0);
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
            for (int n:list){
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
