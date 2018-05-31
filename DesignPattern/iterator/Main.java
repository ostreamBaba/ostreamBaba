package com.design.iterator;

/**
 * @ Create by ostreamBaba on 18-5-31
 * @ √Ë ˆ
 */
public class Main {
    public static void main(String[] args) {
        int length=4;
        BookSelf bookSelf=new BookSelf(length);
        bookSelf.appendBook(new Book("A"));
        bookSelf.appendBook(new Book("B"));
        bookSelf.appendBook(new Book("C"));
        bookSelf.appendBook(new Book("D"));
        Iterator it=bookSelf.iterator();
        while (it.hasNext()){
            Book book=(Book)it.next();
            System.out.println(book.getName());
        }
    }
}
