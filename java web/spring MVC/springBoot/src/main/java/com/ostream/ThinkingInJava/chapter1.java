package com.ostream.ThinkingInJava;

import org.junit.Test;
import org.springframework.test.context.BootstrapWith;

/**
 * @Create by ostreamBaba on 18-4-15
 * @描述
 */
public class chapter1 {

    static int i=7;

    @Test
    public void test(){
        String s1="abc";
        System.out.println(s1);

        //scope
        {
            int z=new Integer(5);
            int x=2;
            {
                int y=3;
                System.out.println(y);
                {
                    x=4;
                    System.out.println(x);
                    System.out.println(y);
                }
            }
            System.out.println(x);
            //z end of scope
        }

        int x=6;
        System.out.println(x);
        int z=1;
        System.out.println(z);

    }

    public class DateOnly{
        private int x=2;
        private int y=3;

        public DateOnly(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void increment(){
        chapter1.i++;
    }

    @Test
    public void test1(){
        //chapter1 c1=new chapter1();
        DateOnly dataonly=new DateOnly(3,4);
        System.out.println(dataonly.getX());
        System.out.println(chapter1.i);
        chapter1.increment();
        System.out.println(chapter1.i);
    }


    @Test
    public void test2(){
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.pathjav"));
    }


    @Test
    public void test3(){
        Integer n3=2;
        Integer n4=2;
        System.out.println(n3.equals(n4));
        int n5=1;
        int n6=1;
        System.out.println(n5==n6);//equals不能用
        Integer n1=new Integer(11);
        Integer n2=new Integer(11);
        System.out.println(n1==n2);//两个不同的对象
        System.out.println(n1.equals(n2));
    }

    @Test
    public void test4(){
        int[] a={1,2,3};
        int[] b;
        b=a;  //引用
        for (int i = 0; i < b.length; i++) {
            b[i]+=1;
        }
        for (int j = 0; j < a.length; j++) {
            System.out.println(a[j]);
        }
    }

}
