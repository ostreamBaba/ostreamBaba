package com.ostream.TankWar;

import java.awt.*;
import java.util.Random;

/**
 * @Create by ostreamBaba on 18-4-14
 * @描述
 */

//发射激光
public class Laser {

    private int x;
    private int y;

    private int width;
    private int height;

    public Laser(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    Color[] colors={Color.blue,Color.pink,Color.green,Color.yellow,Color.white,Color.CYAN,Color.ORANGE};
    private Random r=new Random();

    public void draw(){
        int rc=r.nextInt(colors.length);
        Color c=colors[rc];

        //todo

    }


}
