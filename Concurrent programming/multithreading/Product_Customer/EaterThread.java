package com.multithreading.Product_Customer;

import java.util.Random;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ customer
 */
public class EaterThread extends Thread{
    private final Random random;
    private final table table;

    public EaterThread(String name,table table,long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            while (true){
                String cake=table.take();
                Thread.sleep(random.nextInt(1000));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
