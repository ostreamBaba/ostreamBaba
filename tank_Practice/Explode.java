package com.ostream.TankWar;

import java.awt.*;

/**
 * @Create by ostreamBaba on 18-4-14
 * @描述
 */
public class Explode {

    private int x;
    private int y;
    private int height;
    private int width;
    private int step;
    private TankClient tc;

    {
        step=3;
        height=50;
        width=50;
    }

    public Explode(int x, int y, TankClient tc) {
        this.x = x - 10;
        this.y = y - 10;
        this.tc = tc;
    }

    public void draw(Graphics g){
        if(0==step){
            tc.getExplodes().remove(this);
            return;
        }
        g.setColor(Color.RED);
        g.fillOval(x,y,width,height);
        x+=10;
        y+=10;
        width-=20;
        height-=20;
        --step;
    }

}
