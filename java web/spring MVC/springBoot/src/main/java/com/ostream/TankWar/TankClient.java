package com.ostream.TankWar;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Create by ostreamBaba on 18-4-13
 * @描述
 */
public class TankClient extends Frame{


    private static final int TC_WIDTH;
    private static final int TC_HEIGHT;
    private Tank my_Tank=new Tank(true,30,120,this);
    private Tank other_Tank1=new Tank(false,300,100,this);
    private Tank other_Tank2=new Tank(false,360,100,this);
    private Tank other_Tank3=new Tank(false,420,100,this);
    private List<Bullet> bullets=new ArrayList<>();
    private List<Tank> tanks=new ArrayList<>();
    private List<Wall> walls=new ArrayList<>();
    public List<Explode> explodes=new ArrayList<>();


    public List<Bullet> getBullets() {
        return bullets;
    }

    public List<Tank> getTanks() {
        return tanks;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Explode> getExplodes() {
        return explodes;
    }

    static {
        TC_WIDTH=810;
        TC_HEIGHT=690;
    }

    Bullet bullet=new Bullet(400,500,Tank.Direction.LD,this,false);

    Wall w1=new Wall(60,60,300,30);
    Wall w2=new Wall(120,600,420,30);
    Wall w3=new Wall(660,120,30 ,400);


    {
        walls.add(w1);
        walls.add(w2);
        walls.add(w3);
        tanks.add(other_Tank1);
        tanks.add(other_Tank2);
        tanks.add(other_Tank3);
    }

    public void paint(Graphics g){

        if(tanks.size()==0){
            /*other_Tank.setLive(true);
            tanks.add(other_Tank);
            System.out.println("添加成功");*/
        }

        my_Tank.TouchWithTank(tanks);
        my_Tank.draw(g);

        for (int i = 0; i < tanks.size(); i++) {
            Tank t=tanks.get(i);
            t.TouchWithWall(walls);
            t.draw(g);
        }

        for (int i = 0; i < walls.size(); i++) {
            Wall w=walls.get(i);
            w.draw(g);
        }

        /*bullet.draw(g);*/ //子弹test
        for (int i = 0; i < bullets.size(); i++) {  //画出所有子弹
            Bullet b=bullets.get(i);
            b.TouchWithWall(walls);
            b.hitTank(my_Tank);
            b.hitTank(tanks);
            b.draw(g);
        }

        for (int i = 0; i < explodes.size(); i++) {
            Explode e=explodes.get(i);
            e.draw(g);
        }

    }

    //消除闪屏
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = this.createImage(TC_WIDTH,TC_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.fillRect(0, 0, TC_WIDTH,TC_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }


    public void lauchFrame(){
        this.setLocation(300,300);
        this.setSize(TC_WIDTH,TC_HEIGHT);
        this.setBackground(Color.BLACK);
        this.setResizable(true);
        addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                dispose();
                System.exit(0);
            }
        } );
        this.addKeyListener(new keyMonitor());//添加时间监听器
        this.setVisible(true);
        new Thread(new startThread()).start();
    }

    //启动线程
    private class startThread implements Runnable{
        @Override
        public void run() {
            while(true){
                repaint();
                try {
                    Thread.sleep(100); //设置线程运行间隔时间
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //为自己的坦克添加键盘监听
    private class keyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent keyEvent) {
            my_Tank.keyPressed(keyEvent);
        }
        @Override
        public void keyReleased(KeyEvent keyEvent) {
            my_Tank.keyReleased(keyEvent);
        }
    }


    public static void main(String[] args) {
        TankClient tc=new TankClient();
        tc.lauchFrame();
    }


}
