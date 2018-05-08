package com.ostream.JVM;

import org.aspectj.weaver.bcel.asm.AsmDetector;

/**
 * @ Create by ostreamBaba on 18-5-8
 * @ 描述
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * +XX: PretenureSizeThreshold=3145728 大于3MB的对象都会直接在老年代进入分配
 */

//java堆20M 不可扩展 10M新生代 剩余10M给老年代 Eden和Survivor区 8:1

public class testJVM {
    private static final int _1MB=1024*1024;
    public static void testAllocation(){
        byte[] a1, a2, a3, a4;
        a1=new byte[2*_1MB];
        a2=new byte[2*_1MB];
        a3=new byte[2*_1MB];  //发生一次Minor GC
        //a4=new byte[4*_1MB];
    }
    public static void testPretenureSizeThreshold(){
        byte[] a1;
        a1=new byte[4*_1MB];
    }
    public static void testTenuringThreshold(){
        byte[] a1,a2,a3;
        a1=new byte[_1MB/4];
        a2=new byte[4*_1MB];
        a3=new byte[4*_1MB];
        a3=null;
        a3=new byte[4*_1MB];
    }
    public static void main(String[] args) {
        testAllocation();
        //testPretenureSizeThreshold();
        //testTenuringThreshold();
    }
}
