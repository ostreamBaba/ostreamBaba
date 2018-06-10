package com.multithreading.Immutable;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ ÃèÊö
 */
public class PersonThread extends Thread{
    private Person person;

    public PersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+" prints "+person);
        }
    }
}
