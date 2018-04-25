package com.ostream.ThinkingInJavaII.generics;

import java.awt.*;

/**
 * @Create by ostreamBaba on 18-4-25
 * @描述
 */


//在继承的每隔层次上依次添加边界限制
class HoldItem<T>{
    T item;
    public HoldItem(T item) {
        this.item = item;
    }
    public T getItem() {
        return item;
    }
}
class Colored2<T extends HasColor> extends HoldItem<T>{
    public Colored2(T t) {
        super(t);
    }
    Color getColor(){
        return item.getColor();
    }
}
class ColoredDimension<T extends Dimension&HasColor> extends Colored2<T>{
    public ColoredDimension(T t) {
        super(t);
    }
    int getX(){
        return item.x;
    }
}
class Soild2<T extends Dimension&HasColor&Weight> extends ColoredDimension<T>{
    public Soild2(T t) {
        super(t);
    }
    int weight(){
        return item.weight();
    }
}
public class InheritBounds {
    public static void main(String[] args) {
        Soild2<Bounded> soild2=new Soild2<Bounded>(new Bounded());
        soild2.getColor();
        soild2.weight();
        soild2.getX();
        System.out.println(soild2.getItem());
    }

}
