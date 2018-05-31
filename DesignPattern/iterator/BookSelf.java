package com.design.iterator;

/**
 * @ Create by ostreamBaba on 18-5-31
 * @ √Ë ˆ
 */
public class BookSelf implements Aggregate{
    private Book[] books;
    private int last=0;

    public BookSelf(int maxSize) {
        books=new Book[maxSize];
    }

    public Book getBookAt(int index){
        return books[index];
    }

    public void appendBook(Book book){
        books[last++]=book;
    }

    public int getLength(){
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookSelfIterator(this);
    }
}
