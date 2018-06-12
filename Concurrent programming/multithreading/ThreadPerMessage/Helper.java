package com.multithreading.ThreadPerMessage;

/**
 * @ Create by ostreamBaba on 18-6-12
 * @ 描述
 */
//助手类 处理request请求
public class Helper {
    public void handle(int count, char c) {
        System.out.println(" handle("+count+", "+c+") BEING");
        for (int i = 0; i < count; i++) {
            slowly();
            System.out.print(c);
        }
        System.out.println(" ");
        System.out.println(" handle("+count+", "+c+") END");
    }

    private void slowly() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
