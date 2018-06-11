package com.multithreading.GuardedSuspension;

/**
 * @ Create by ostreamBaba on 18-6-11
 * @ ÃèÊö
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue=new RequestQueue();
        new ClientThread(requestQueue,"Client",3143592L).start();
        new ServerThread(requestQueue,"Server",6546897L).start();
    }
}
