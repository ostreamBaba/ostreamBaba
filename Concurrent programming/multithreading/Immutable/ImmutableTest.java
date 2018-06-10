package com.multithreading.Immutable;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ ÃèÊö immutableºÍ¼ÓËø ²âÊÔ 46:14014
 */

public class ImmutableTest {
    private static final long CALL_COUNT=100000000L;

    private static void trial(String msg,long count,Object obj){
        System.out.println(msg+" BEING");
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            obj.toString();
        }
        long endTime=System.currentTimeMillis();
        System.out.println("msg"+" END");
        System.out.println(endTime-startTime);
    }

    public static void main(String[] args) {
        trial("NoSynch",CALL_COUNT,new NotSynch());
        trial("Synch",CALL_COUNT,new Synch());
    }
}


class NotSynch{
    private final String name="NotSynch";
    @Override
    public String toString() {
        return "["+name+"]";
    }
}

class Synch{
    private final String name="synch";
    @Override
    public synchronized String toString() {
        return super.toString();
    }
}