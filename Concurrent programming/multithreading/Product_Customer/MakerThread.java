package com.multithreading.Product_Customer;

import java.util.Random;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ Producer
 */
public class MakerThread extends Thread{

    private final Random random;

    private final table table;

    private static int id=0;

    public MakerThread(String name,table table,long seed){
        super( name );
        this.random = new Random(seed);
        this.table = table;
    }

    @Override
    public void run() {
        try{
            while (true){
                Thread.sleep(random.nextInt(1000));
                String cake="[ Cake No."+nextId()+" by "+getName()+" ]";
                table.put(cake);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private synchronized static int nextId(){
       return ++id;
    }

}
