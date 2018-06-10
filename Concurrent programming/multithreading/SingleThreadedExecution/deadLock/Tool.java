package com.multithreading.SingleThreadedExecution.deadLock;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ √Ë ˆ
 */
public class Tool {
    private final String name;
    public Tool(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "[ "+name+" ]";
    }
}
