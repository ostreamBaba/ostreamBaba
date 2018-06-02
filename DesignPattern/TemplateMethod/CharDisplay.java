package com.design.TemplateMethod;

/**
 * @ Create by ostreamBaba on 18-6-2
 * @ ÃèÊö
 */
public class CharDisplay extends AbstractDisplay{
    private char ch;
    public CharDisplay(char ch) {
        super();
        this.ch = ch;
    }
    @Override
    public void open() {
        System.out.print("(");
    }
    @Override
    public void print() {
        System.out.print(ch);
    }
    @Override
    public void close() {
        System.out.print(")");
    }
}
