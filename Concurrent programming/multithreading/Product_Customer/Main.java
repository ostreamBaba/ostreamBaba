package com.multithreading.Product_Customer;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ ÃèÊö
 */
public class Main {
    public static void main(String[] args) {
        table table=new table(3);
        new MakerThread("makerThread-1",table,31415).start();
        new MakerThread("makerThread-2",table,92873).start();
        new MakerThread("makerThread-3",table,58768).start();
        new EaterThread("eaterThread-1",table,32856).start();
        new EaterThread("eaterThread-2",table,63643).start();
        new EaterThread("eaterThread-3",table,38327).start();
    }
}
