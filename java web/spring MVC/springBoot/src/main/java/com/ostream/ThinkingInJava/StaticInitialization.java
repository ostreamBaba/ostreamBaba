package com.ostream.ThinkingInJava;

/**
 * @Create by ostreamBaba on 18-4-15
 * @描述
 */

public class StaticInitialization {


    static void printArray(Object[] objects){
        for(Object b:objects){
            System.out.println(b.getClass());
            System.out.println(b+" ");
        }
    }

    static void printArrayIsChange(Object... args){ //传入可变参数
        for(Object b:args){
            System.out.println(b+" ");
        }
    }

    public static void main(String[] args) {
        Bowl b = new Bowl( 12 );
        StaticInitialization.printArray(new Object[]{new Integer(1),new Integer(2)});
        StaticInitialization.printArray(new Object[]{new A(),new A()});
        StaticInitialization.printArrayIsChange(12,13.4f,12.21d);
        StaticInitialization.printArrayIsChange();
    }





}
class Bowl{
    Bowl(int m){
        System.out.println("bowl"+m);
    }
}

class A{}