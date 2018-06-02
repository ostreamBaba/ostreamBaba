package com.design.adapter.chapter1;

/**
 * @ Create by ostreamBaba on 18-6-2
 * @ ÀàÊÊÅäÆ÷Ä£Ê½
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
