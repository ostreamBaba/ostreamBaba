package com.ostream.TankWar;

import java.awt.*;

/**
 * @Create by ostreamBaba on 18-4-13
 * @描述
 */
public class Wall {


    private int x;
    private int y;
    private int width;
    private int height;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(x,y,width,height);
    }

    public Rectangle getRect(){
        return new Rectangle(x,y,width,height);
    }



}
