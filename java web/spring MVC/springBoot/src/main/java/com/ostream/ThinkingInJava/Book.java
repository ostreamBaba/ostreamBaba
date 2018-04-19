package com.ostream.ThinkingInJava;

/**
 * @Create by ostreamBaba on 18-4-15
 * @描述
 */

//finalize ????????????????????
public class Book{

    boolean cout=false;
    Book(boolean cout) {
        this.cout = cout;
    }

    void cin(){
        cout=false;
    }

    @Override
    protected void finalize() throws Throwable {
        if(cout){
            super.finalize();
        }
        if(cout){
            System.out.println("error");
        }
    }

    class price{

    }

    public static void main(String[] args) {
        Book n=new Book(true);
        n.cin();
        new Book(true); //未被签入
        System.gc();
        /*for(String s:args){

        }*/
    }
}