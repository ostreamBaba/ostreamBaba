package com.ostream.JVM;
/**
 * +XX:+PrintGCDetails //打印gc日志
 * @ Create by ostreamBaba on 18-5-7
 * @ 描述
 */
//引用计数算法在每个对象都维护着一个内存字段来统计它被多少”部分”使用—引用计数器,每当有一个新的引用指向该对象时,引用计数器就+1 ,
// 每当指向该引用对象失效时该计数器就-1 ,当引用数量为0的时候,则说明对象没有被任何引用指向,可以认定是”垃圾”对象

public class RefenenceCountingGC {
    private Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];
    public static void testGC() {
        RefenenceCountingGC objA = new RefenenceCountingGC(); //RefenenceCountingGC实例1被obj1引用 引用数+1
        RefenenceCountingGC objB = new RefenenceCountingGC(); //RefenenceCountingGC实例2被obj2引用 引用数+1
        objA.instance = objB; //objA的instance属性指向objB,而objB指向GcObject实例2,故RefenenceCountingGC实例2引用+1,为2
        objB.instance = objA;//objB的instance属性指向objA,而objA指向GcObject实例2,故RefenenceCountingGC实例2引用+1,为2
        objA = null;//obj1不再指向RefenenceCountingGC实例1,其引用计数减1,结果为1.
        objB = null;//obj2不再指向RefenenceCountingGC实例2,其引用计数减1,结果为1.
        //若java虚拟机用的是计数算法 那么RefenenceCountingGC实例1 RefenenceCountingGC实例2都不会被回收
        //可是根据下面的GC日志 [PSYoungGen: 888K->0K(36864K)] [ParOldGen: 0K->799K(84992K)] 888K->799K(121856K)(被回收) 所以jvm并不是通过计数算法来判断对象是否存活
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}

//[Full GC (System.gc()) [PSYoungGen: 888K->0K(36864K)] [ParOldGen: 8K->806K(84992K)] 896K->806K(121856K),
//[Metaspace: 3161K->3161K(1056768K)], 0.0055535 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]