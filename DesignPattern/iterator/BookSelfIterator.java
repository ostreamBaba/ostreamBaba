package com.design.iterator;

/**
 * @ Create by ostreamBaba on 18-5-31
 * @ √Ë ˆ
 */
public class BookSelfIterator implements Iterator{
    private BookSelf bookSelf;
    private int index=0;
    public BookSelfIterator(BookSelf bookSelf) {
        this.bookSelf = bookSelf;
    }
    @Override
    public boolean hasNext() {
        if(index<bookSelf.getLength()){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public Object next() {
        return bookSelf.getBookAt(index++);
    }
}
