package com.ostream.test;

/**
 * @Create by ostreamBaba on 18-4-12
 * @描述
 */
public class this_test {

    private int num1;
    private int num2;

    public this_test() {
        this.num1=20;
    }

    public this_test(int num1,int num2) {
        this();
        this.num2 = num2;
    }

    public this_test increment(){
        /*this_test this_test=new this_test(1,2);
        ++this_test.num1;
        ++this_test.num2;
        return this_test;*/
        ++num1;
        ++num2;
        return this;
    }

    public void print(){
        System.out.println("num1="+num1+",num2="+num2);
    }

    public static void main(String[] args) {
        this_test test=new this_test(30,40);
        test.increment().increment().increment().print();
    }

}
