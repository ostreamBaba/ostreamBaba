package com.ostream.effective_java;

import com.sun.org.apache.regexp.internal.RE;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Create by ostreamBaba on 18-5-2
 * @描述
 */
public class InstanceOf {
    public static void main(String[] args) {
        String str="abc";
        boolean isObject=str instanceof Object;
        System.out.println(isObject);
    }
}

//equals 规则：
//自反性
//对称性
//传递性
//一致性
//非空性

final class CaseInsensitiveString{
    private final String s;
    public CaseInsensitiveString(String s) {
        if(null==s){
            throw new NullPointerException();
        }
        this.s=s;
    }
    //对称性
    @Override
    public boolean equals(Object o) {
        /*if(o instanceof CaseInsensitiveString){
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        if(o instanceof String){
            return s.equalsIgnoreCase((String)o);
        }
        return false;*/
        return (o instanceof CaseInsensitiveString)&&(s.equalsIgnoreCase(((CaseInsensitiveString) o).s));//符合对称性
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis=new CaseInsensitiveString("polish");
        String s="polish";
        System.out.println(cis.equals(s)); //不区分大小写的字符串知道String 可是String却不知道不区分大小写的字符串 违反了对称性
        System.out.println(s.equals(cis));
        List<CaseInsensitiveString> list=new ArrayList<CaseInsensitiveString>();
        list.add(cis);
        System.out.println(list.contains(s)); //??? 结果不确定
    }
}

class Point{
    private final int x;
    private final int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof Point){
            Point result=(Point)o;
            return (result.x==x)&&(result.y==y);
        }
        /*if(o!=null&&o.getClass()==getClass()){
            Point result=(Point)o;
            return (result.x==x)&&(result.y==y);
        }*/
        //用getClass代替instanceof 在拓展可实例化的类的同时 即增加新的组件 同时又保留equals约定(只有当对象具有相同的实现时)
        return false;
    }
}
class ColorPoint extends Point{
    private final Color color;
    public ColorPoint(int x, int y, Color color) {
        super( x, y );
        this.color = color;
    }
    //覆盖
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        if (!(o instanceof ColorPoint)) {
            //ColorPoint的超类与ColorPoint
            return o.equals( this );
        }
        return super.equals( o ) && (((ColorPoint) o).color == color);
    }

    public static void main(String[] args) {
        ColorPoint p1=new ColorPoint(1,2,Color.blue);
        Point p2=new Point(1,2);
        ColorPoint p3=new ColorPoint(1,2,Color.cyan);
        //考虑了对称性 牺牲了传递性
        //我们无法在拓展可实例化的类的同时 即增加新的组件 同时又保留equals约定(这里不遵守传递性)
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p3));
    }
}


class Point1{
    private final int x;
    private final int y;
    public Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if(o!=null&&o.getClass()==getClass()){
            Point1 result=(Point1)o;
            return (result.x==x)&&(result.y==y);
        }
        //用getClass代替instanceof 在拓展可实例化的类的同时 即增加新的组件 同时又保留equals约定(只有当对象具有相同的实现时)
        return false;
    }
}
//不添加值组件的方式拓展Point1
class CountPoint extends Point1{
    private static final AtomicInteger counter=new AtomicInteger(0);
    public CountPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }
    public int numberCreated(){
        return counter.get();
    }
    public static void main(String[] args) {
        System.out.println(Circle.onUnitCircle(new CountPoint(1,2))); //getClass false
    }
}

class Circle{
    private static final List<Point1> unitCircle;
    static{
        unitCircle=new ArrayList<Point1>();
        unitCircle.add(new Point1(1,2));
        unitCircle.add(new Point1(-1,2));
        unitCircle.add(new Point1(1,-2));
        unitCircle.add(new Point1(-1,-2));

    }
    public static boolean onUnitCircle(Point1 p){
        return unitCircle.contains(p);
    }
    public static void main(String[] args) {
        Point1 p1=new Point1(1,2);
        Point1 p2=new Point1(1,2);
        Point1 p3=new Point1(1,2);
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p3));
        System.out.println(onUnitCircle(p1)); //true
    }
}

//复合优于继承
class ColorPoint1{
    private final Point point;
    private final Color color;
    public ColorPoint1(int x,int y,Color color) {
        if(color==null){
            throw new NullPointerException();
        }
        point=new Point(x,y);
        this.color = color;
    }
    public Point getPoint() {
        return point;
    }
    @Override
    public boolean equals(Object o) {
        /*if(o==null){
            return false;
        }*/
        if(!(o instanceof ColorPoint1)){
            return false;
        }  //由于有类型检测 所以o==null可以省略
        ColorPoint1 cp1=(ColorPoint1)o;
        return cp1.color.equals(color)&&cp1.point.equals(point);
    }
}

//基本类型用== 对象引用域递归地用equal float域用Float.compare Double域用Double.compare
//数组域可以用Arrays.equals方法