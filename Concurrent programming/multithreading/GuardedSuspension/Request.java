package com.multithreading.GuardedSuspension;

/**
 * @ Create by ostreamBaba on 18-6-11
 * @ 模拟客户端向服务端发送请求
 */
public class Request {
    private final String name;
    public Request(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "["+name+"]";
    }
}
