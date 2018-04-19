package com.ostream.TankWar;

import java.awt.*;
import java.util.List;


/**
 * @Create by ostreamBaba on 18-4-12
 * @描述
 */
public class Bullet {

    private int x;
    private int y;
    private int width;
    private int height;
    private Tank.Direction dir;
    private int x_speed;
    private int y_speed;
    private boolean isLive;
    private boolean isEnemy;
    private TankClient tc;

    {
        width=10;
        height=10;
        x_speed=30;
        y_speed=30;
        isLive=true;
    }

    public Bullet(int x, int y, Tank.Direction dir,TankClient tc,Boolean isEnemy) {
        this.dir = dir;
        this.tc = tc;
        this.isEnemy = isEnemy;

        //判断炮筒方向确定子弹的初始位置

        this.x=x;
        this.y=y;
    }

    public Rectangle getRect(){
        return new Rectangle(x,y,width,height);
    }


    public void draw(Graphics g){
        if(!isLive){
            tc.getBullets().remove(this);
            /*System.out.println("撞墙了不能画"+y);*/
            return;
        }

        if(isEnemy) {
            g.setColor(Color.yellow);
        }else {
            g.setColor(Color.blue);
        }

        /*System.out.println("子弹的y： "+y);*/

        g.fillOval(x,y,width,height);
        move();
    }

    public void move(){
        switch (dir){
            case L:x-=x_speed;break;
            case R:x+=x_speed;break;
            case D:y+=y_speed;break;
            case U:y-=y_speed;break;
            case LU:x-=x_speed;y-=y_speed;break;
            case LD:x-=x_speed;y+=y_speed;break;
            case RD:x+=x_speed;y+=y_speed;break;
            case RU:x+=x_speed;y-=y_speed;break;
        }

        if(x<0||y<0||x>tc.getWidth()||y>tc.getHeight()){
            isLive=false;
        }

    }

    //判断子弹发生碰撞  如果死亡产生一个爆炸 延时画产出动态效果
    public void TouchWithWall(List<Wall> wallList ){
        for(Wall w:wallList){
            if(this.getRect().intersects(w.getRect())){
                System.out.println("接触到"+y);
                isLive=false;
            }
        }
    }

    //子弹打到自己的坦克
    public void hitTank(Tank tank){
        if(!this.isEnemy){
            if(tank.isLive()&&this.getRect().intersects(tank.getRect())){
                int blood=tank.getBlood();
                blood-=20;
                tank.setBlood(blood);
                isLive=false;
                if(blood<0){
                    tank.setLive(false);
                    Explode e=new Explode(x,y,tc);
                    tc.getExplodes().add(e);
                }
            }
        }
    }

    //子弹打别人的坦克
    public void hitTank(List<Tank> tankList){
        /*System.out.println("调用打坦克");*/
        for(Tank t:tankList){
            /*System.out.println(this.isEnemy);*/
            if(this.isEnemy){
                /*System.out.println(this.getRect().intersects(t.getRect()));*/
                if(t.isLive()&&this.getRect().intersects(t.getRect())){
                    /*System.out.println("打到了");*/
                    t.setLive(false);
                    isLive=false;
                    Explode e=new Explode(x,y,tc);
                    tc.getExplodes().add(e);
                    return;
                }
            }
        }
    }
}
