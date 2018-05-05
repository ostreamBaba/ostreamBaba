package com.ostream.effective_java.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-5-5
 * @描述
 */

//返回零长度的数组或者集合 而不是null
public class chapter42 {
    public static void main(String[] args) {
        int[] dit={1,2,3,4,5,6};
        System.out.println(Arrays.toString(dit));//将任何类型转换成字符串
    }
}

class Cheese{}

class shop {
    private final List<Cheese> cheeseInStock;
    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];
    public shop(List<Cheese> cheeseInStock) {
        this.cheeseInStock = cheeseInStock;
    }
    //返回零长度数组
    public Cheese[] getCheeses(){
        return cheeseInStock.toArray(EMPTY_CHEESE_ARRAY);
    }
    //返回零长度集合
    public List<Cheese> getCheesesList(){
        if(cheeseInStock.isEmpty()){
            return Collections.emptyList();
        }else{
            return new ArrayList<Cheese>(cheeseInStock);
        }
    }

    public static void main(String[] args) {
        List<Cheese> cheeses=new ArrayList<Cheese>();
        shop test=new shop(cheeses);
        Cheese[] cheeses1=test.getCheeses();
        System.out.println(cheeses1.length);
    }
}