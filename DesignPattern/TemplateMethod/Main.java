package com.design.TemplateMethod;

/**
 * @ Create by ostreamBaba on 18-6-2
 * @ ÃèÊö
 */
public class Main {
    public static void main(String[] args) {
        AbstractDisplay display=new CharDisplay('1');
        //ÀïÊÏÌæ»»Ô­Ôò
        display.display();
    }
}
