package com.ostream.ThinkingInJavaII.generics;

import java.awt.*;

/**
 * @Create by ostreamBaba on 18-4-25
 * @描述
 */

//边界

interface HasColor{
    Color getColor();
}

class Colored<T extends HasColor>{
    T item;
    public Colored(T item) {
        this.item = item;
    }
    public T getItem() {
        return item;
    }
    Color getColor(){
        return item.getColor();
    }
}

class Dimension{
    public int x,y,z;
}

//This won't work --class must be first
//!class ColorDemensiom<T extends HasColor&Dimension>

class ColorDemension<T extends Dimension&HasColor>{
    T item;
    public ColorDemension(T item) {
        this.item = item;
    }
    public T getItem() {
        return item;
    }
    Color getColor(){
        return item.getColor();
    }
    int getX(){
        return item.x;
    }
    int getY(){
        return item.y;
    }
    int getZ(){
        return item.z;
    }
}

interface Weight{
    int weight();
}

class Soild<T extends Dimension&HasColor&Weight>{
    T item;
    public Soild(T item) {
        this.item = item;
    }
    public T getItem() {
        return item;
    }
    Color getColor(){
        return item.getColor();
    }
    int getX(){
        return item.x;
    }
    int getY(){
        return item.y;
    }
    int getZ(){
        return item.z;
    }
    int weight(){
        return item.weight();
    }

}

class Bounded extends Dimension implements HasColor,Weight {
    @Override
    public Color getColor() {
        return null;
    }
    @Override
    public int weight() {
        return 0;
    }
}
public class BasicBounds{
    public static void main(String[] args) {
        Soild<Bounded> soild=new Soild<Bounded>(new Bounded());
        System.out.println(soild.getColor());
        soild.getY();
        soild.weight();
    }
}

