package com.multithreading.SingleThreadedExecution.deadLock;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ √Ë ˆ
 */
public class EaterThread extends Thread{
    private String name;
    private final Tool leftHand;
    private final Tool rightHand;

    public EaterThread(String name, Tool lefeHand, Tool rightHand) {
        this.name = name;
        this.leftHand = lefeHand;
        this.rightHand = rightHand;
    }

    @Override
    public void run() {
        while (true){
            eat();
        }
    }

    private void eat() {
        synchronized (leftHand){
            System.out.println(name+" takes up "+leftHand+" (left).");
            synchronized (rightHand){
                System.out.println(name+" takes up "+rightHand+" (right).");
                System.out.println(name+" is eating now");
                System.out.println(name+" puts down "+rightHand+" (right).");
            }
            System.out.println(name+" puts down"+leftHand+" (left).");
        }
    }
}

//b takes up [ fork ] (left).
//a takes up [ span ] (left). œﬂ≥Ã÷’÷π À¿À¯
