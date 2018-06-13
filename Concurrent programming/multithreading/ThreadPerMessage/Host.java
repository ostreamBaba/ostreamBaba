package com.multithreading.ThreadPerMessage;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ 描述
 */

//Host角色收到Client角色的请求之后 会创建并启动一个新的线程
public class Host {
    private final Helper helper=new Helper();
    public void request(final int count,final char c){
        System.out.println(" request("+count+", "+c+") BEING");

        new Thread(){
            @Override
            public void run() {
                helper.handle(count,c);
            }
        }.start();

        /*new Thread(  //法二
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count,c);
                    }
                }
        ).start();

        Runnable runnable=new Runnable() {
            @Override  //法三
            public void run() {
                helper.handle(count,c);
            }
        };
        new Thread(runnable).start();*/

        System.out.println(" request("+count+", "+c+") END");
    }
}
