package com.ostream.ThinkingInJavaII.string;

import java.util.Random;

/**
 * @Create by ostreamBaba on 18-4-22
 * @描述
 */
public class UsingStringBuilder {
    public static Random r=new Random(47);

    @Override
    public String toString() {
        //只创建了一个StringBuilder对象
        StringBuilder sb=new StringBuilder("[");
        for (int i = 0; i < 10; i++) {
            sb.append(r.nextInt(100));
            sb.append(", ");
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append("]");
        return sb.toString();
    }
    public static void main(String[] args) {
        UsingStringBuilder usb=new UsingStringBuilder();
        System.out.println(usb);
    }
}
