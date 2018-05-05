package com.ostream.effective_java.classes;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Create by ostreamBaba on 18-5-5
 * @描述
 */
public class chapter39 {
}
//必要时进行保护性拷贝
final class Period{
    //start end域真正被封装到Period(真正不可变了)内部了
    private final Date start;
    private final Date end;
    private Period(Date start, Date end) {
        if(start.compareTo(end)>0){
            throw new IllegalArgumentException(start+" after "+end);
        }
        //this.start = start;
        //this.end = end;
        this.start=new Date(start.getTime()); //不用clone方法拷贝 是因为Date类是非final的(子类实例攻击)
        this.end=new Date(end.getTime());
        //对于可变参数进行保护性拷贝
    }
    /*public Date getStart() {
        return start;
    }
    public Date getEnd() {
        return end;
    }*/
    public static Period getInstance(Date start,Date end){
        return new Period(start,end);
    }

    public Date getStart() {
        return new Date(start.getTime());
    }
    public Date getEnd() {
        return new Date(end.getTime());
    }
    //Date是可变的
    public static void main(String[] args) {
        /*Date end=new Date();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){

        }
        Date start=new Date();*/
        Date start=new Date();
        Date end=new Date();
        Period p=getInstance(start,end);
        start.setYear(78);
        //由公有访问方法改变内部私有成员
        p.end.setYear(78);


    }
}