package com.ostream.effective_java.classes;

/**
 * @Create by ostreamBaba on 18-5-3
 * @描述
 */
//

final class Shape{}
//标签类 缺点太多
public class Figure{
    enum Shape{RECYANGLE,CIRCLE};
    final Shape shape;
    double length;
    double width;
    double redius;
    Figure(double redius){
        shape=Shape.CIRCLE;
        this.redius=redius;
    }
    public Figure(double length, double width) {
        shape=Shape.RECYANGLE;
        this.length = length;
        this.width = width;
    }
    double area(){
        switch (shape){
            case RECYANGLE:
                return length*width;
            case CIRCLE:
                return Math.PI*(redius*redius);
            default:
                throw new AssertionError();
        }
    }
}
//子类型化
abstract class FigureI{
    abstract double area();
}
final class Circle extends FigureI{
    final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    double area() {
        return Math.PI*(radius*radius);
    }
}
class Rectangle extends FigureI{
    final double length;
    final double weight;
    public Rectangle(double length, double weight) {
        this.length = length;
        this.weight = weight;
    }
    @Override
    double area() {
        return length*weight;
    }
}

class Square extends Rectangle{
    public Square(double length) {
        super( length, length);
    }
}