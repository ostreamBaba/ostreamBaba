package com.multithreading.SingleThreadedExecution.UnSafe;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ ÃèÊö
 */
public class UserThread extends Thread{

    private final Gate gate;
    private final String name;
    private final String address;

    public UserThread(Gate gate, String name, String address) {
        this.gate = gate;
        this.name = name;
        this.address = address;
    }

    @Override
    public void run() {
        System.out.println(name+" being");
        while (true){
            gate.pass(name,address);
        }
    }
}
