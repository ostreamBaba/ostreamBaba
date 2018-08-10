package com.ThinkingInJava.capter17.Queue;

import java.util.*;

/**
 * @ Create by ostreamBaba on 18-8-10
 * @ 描述
 */

//　Deque是Queue的子接口,我们知道Queue是一种队列形式,而Deque则是双向队列,
// 它支持从两个端点方向检索和插入元素,因此Deque既可以支持LIFO形式也可以支持LIFO形式.
// Deque接口是一种比Stack和Vector更为丰富的抽象数据形式,因为它同时实现了以上两者.
//通用实现主要有两个实现类ArrayDeque和LinkedList.
public class DequeTest {

    static void fillTest(Deque<Integer> deque){
        for (int i = 20; i < 27; i++) {
            deque.addFirst(i);
        }
        for (int i = 50; i < 55; i++) {
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> di=new ArrayDeque<Integer>(50);
        fillTest(di);
        System.out.println(di);
        while (di.size()!=0){
            System.out.print(di.removeFirst()+" ");
        }
        System.out.println();
        fillTest(di);
        while (di.size()!=0){
            System.out.print(di.removeLast()+" ");
        }
    }
}
