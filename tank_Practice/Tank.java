package com.ostream.TankWar;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @Create by ostreamBaba on 18-4-12
 * @描述
 */
public class Tank {


    private int X_speed;
    private int Y_speed;
    private int width;
    private int height;

    private int blood;
    private boolean isEnemy;

    private boolean isLive;

    private int per_x;
    private int per_y;

    private Random r;
    private int step;

    private int x;
    private int y;
    private boolean bL,bU,bD,bR;


    private TankClient tc;

    {
        r=new Random();
        X_speed=30;
        Y_speed=30;
        width=30;
        height=30;
        blood=100;
        isEnemy=true;
        isLive=true;
        bL=false;
        bU=false;
        bD=false;
        bR=false;
    }


    public boolean isEnemy() {
        return isEnemy;
    }

    public boolean isLive() {
        return isLive;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    enum Direction{L,U,D,R,LU,LD,RU,RD,STOP}

    private Direction tkDir=Direction.STOP;
    private Direction ptDir=Direction.D;

    private BloodBar bloodBar;

    public Tank(boolean isEnemy, int x, int y) {
        this.isEnemy = isEnemy;
        this.x = x;
        this.y = y;
        bloodBar=new BloodBar();
    }

    public Tank(boolean isEnemy, int x, int y, TankClient tc) {
        this(isEnemy,x,y);
        this.tc = tc;
    }

    //画坦克
    public void draw(Graphics g){
        if(!isLive){
            tc.getTanks().remove(this);  //若坦克被消灭则移除这个坦克
            return;
        }
        Color c=g.getColor();
        /*System.out.println(c);*/
        if(!isEnemy){
            g.setColor(Color.blue);
        }else{
            g.setColor(Color.yellow);
        }
        g.fillOval(x,y,width,height);
        g.setColor(c);

        if(isEnemy){
            bloodBar.draw(g);
        }

        switch(ptDir) {
            case L:
                g.drawLine(x + width/2, y + height/2, x, y + height/2);
                break;
            case LU:
                g.drawLine(x + width/2, y + height/2, x, y);
                break;
            case U:
                g.drawLine(x + width/2, y + height/2, x + width/2, y);
                break;
            case RU:
                g.drawLine(x + width/2, y + height/2, x + width, y);
                break;
            case R:
                g.drawLine(x + width/2, y + height/2, x + width, y + height/2);
                break;
            case RD:
                g.drawLine(x + width/2, y + height/2, x + width, y + height);
                break;
            case D:
                g.drawLine(x + width/2, y + height/2, x + width/2, y + height);
                break;
            case LD:
                g.drawLine(x + width/2, y + height/2, x, y + height);
                break;
        }

        move();

    }

    public void move(){
        this.per_x=x;
        this.per_y=y;

        /*System.out.println(tkDir);*/

        switch (tkDir){
            case L:x-=X_speed;break;
            case R:x+=X_speed;break;
            case D:y+=Y_speed;break;
            case U:y-=Y_speed;break;
            case LU:x-=X_speed;y-=Y_speed;break;
            case LD:x-=X_speed;y+=Y_speed;break;
            case RD:x+=X_speed;y+=Y_speed;break;
            case RU:x+=X_speed;y-=Y_speed;break;
            default:break;
        }

        /*System.out.println(y);*/
        if(this.tkDir!=Direction.STOP){
            this.ptDir=this.tkDir;
        }

        //敌方AI 随机生成移动的方向和移动的步数
        if(!isEnemy){
            Direction[] dirs=Direction.values();
            if(0==step){
                step=r.nextInt(10)+3;
                int rd=r.nextInt(8);
                tkDir=dirs[rd];
            }
            --step;
            if(r.nextInt(40)>25){
                fire(ptDir);
            }
        }

        //对边界进行判断
        if(x<0){
            x=0;
            step=0;
        }
        if(y<30){
            y=30;
            step=0;
        }
        if(x+this.width>tc.getWidth()){
            x=tc.getWidth()-this.width;
            step=0;
        }
        if(y+this.height>tc.getHeight()){
            y=tc.getHeight()-this.height;
            step=0;
        }

        if(isEnemy){
            locDirection();//按下键移动 判断是否停下来 使其需要键盘控制才能够移动
        }
    }
    //根据方向发射子弹
    public void fire(Direction ptDir) {
        if(!isLive){
            return;
        }
        Bullet bullet=new Bullet(x+width/3,y+height/3,ptDir,tc,isEnemy);
        tc.getBullets().add(bullet);
        /*System.out.println(tc.getBullets().size());*/
    }

    //判断坦克此时的方向
    public void locDirection(){
        if(bL&&!bR&&!bD&&!bU){
            tkDir=Direction.L;
        }else if(!bL&&bR&&!bD&&!bU){
            tkDir=Direction.R;
        }else if(!bL&&!bR&&bD&&!bU){
            tkDir=Direction.D;
        }else if(!bL&&!bR&&!bD&&bU){
            tkDir=Direction.U;
        }else if(bL&&!bR&&bD&&!bU){
            tkDir=Direction.LD;
        }else if(bL&&!bR&&!bD&&bU){
            tkDir=Direction.LU;
        }else if(!bL&&bR&&!bD&&bU) {
            tkDir=Direction.RU;
        }else if(!bL&&bR&&bD&&!bU){
            tkDir=Direction.RD;
        }else if(!bL&&!bR&&!bD&&!bU){
            tkDir=Direction.STOP;
        }
    }

    //按下键盘
    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();
        switch (key){
            case KeyEvent.VK_Q:
                for (int i = 0; i < 5; i++) {
                    Tank tank=new Tank(false,300+i*30+30,100,tc);
                    tc.getTanks().add(tank);
                }
                break;
            case KeyEvent.VK_R:
                if(isEnemy){
                    isLive=true;
                    blood=100;
                }
                break;
            case KeyEvent.VK_J:
                System.out.println("按下j");
                fire(ptDir);break;
            case KeyEvent.VK_W:
                System.out.println("按下w");
                bU=true;break;
            case KeyEvent.VK_S:
                System.out.println("按下s");
                bD=true;break;
            case KeyEvent.VK_D:
                System.out.println("按下d");
                bR=true;break;
            case KeyEvent.VK_A:
                System.out.println("按下a");
                bL=true;
        }
        /*System.out.println(bL+","+bU+","+bR+","+bD);*/
        locDirection();
    }

    //松开键盘
    public void keyReleased(KeyEvent e){
        int key=e.getKeyCode();
        switch (key){
            case KeyEvent.VK_W:
                System.out.println("松开w");
                bU=false;break;
            case KeyEvent.VK_S:
                System.out.println("松开s");
                bD=false;break;
            case KeyEvent.VK_D:
                System.out.println("松开d");
                bR=false;break;
            case KeyEvent.VK_A:
                System.out.println("松开a");
                bL=false;
        }
        /*System.out.println(bL+","+bU+","+bR+","+bD);*/
    }

    //回归之前的坐标位置
    public void stay(){
        this.x=this.per_x;
        this.y=this.per_y;
    }

    //判断是否相撞
    public Rectangle getRect(){
        return new Rectangle(x,y,width,height);
    }

    //判断与墙相撞
    public boolean TouchWithWall(List<Wall> walls){
        for(Wall w:walls){
            if(this.getRect().intersects(w.getRect())){
                this.stay();
                return true;
            }
        }
        return false;
    }

    //判断与其他坦克相撞
    public boolean TouchWithTank(List<Tank> tanks){
        for(Tank t:tanks){
            if(this!=t){
                if(this.isLive&&t.isLive&&this.getRect().intersects(t.getRect())){
                    this.stay();
                    t.stay();
                    return true;
                }
            }
        }
        return false;
    }

    //血条
    public class BloodBar{
        private void draw(Graphics g){
            g.setColor(Color.RED);
            g.fillRect(x,y-10,width*blood/100,8);
        }
    }


}
