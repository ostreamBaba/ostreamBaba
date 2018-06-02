package com.design.adapter.chapter2;

/**
 * @ Create by ostreamBaba on 18-6-2
 * @ 对象适配器模式
 */
public class Banner {

    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen(){
        System.out.println("("+string+")");
    }

    public void showWithAster(){
        System.out.println("**"+string+"**");
    }
}
