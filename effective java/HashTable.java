package com.ostream.effective_java;

/**
 * @Create by ostreamBaba on 18-5-2
 * @描述
 */

//轻量级单向链表
public class HashTable implements Cloneable{
    private Entry[] buckets;
    private static class Entry{
        final Object key;
        Object value;
        Entry next;
        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        //深度拷贝
        Entry deepCopy(){   //递归
            return new Entry(key,value,next==null?null:deepCopy());
        }
        Entry deepCopy1(){  //迭代
            Entry result=new Entry(key,value,next);
            for(Entry p=result.next;p!=null;p=p.next){
                p=new Entry(p.key,p.value,p.next);
            }
            return result;
        }
    }
    @Override
    public HashTable clone(){
        try{
            HashTable result=(HashTable)super.clone();
            result.buckets=new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++) {
                if(buckets[i]!=null){
                    result.buckets[i]=buckets[i].deepCopy();
                }
            }
            return result;
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}
