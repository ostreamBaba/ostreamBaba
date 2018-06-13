package com.multithreading.ThreadPerMessage.WebTest;

import java.io.IOException;

/**
 * @ Create by ostreamBaba on 18-6-13
 * @ √Ë ˆ
 */
public class Main {
    public static void main(String[] args) {
        try{
            new MiniServer(8888).execute();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
