package com.multithreading.SingleThreadedExecution.UnSafe;

import org.apache.http.annotation.NotThreadSafe;

/**
 * @ Create by ostreamBaba on 18-6-10
 * @ 不使用Single Threaded Execution模式(存在数据竞争)
 */
/*出现 BROKEN： pass出现数据竞争导致check判断条件成立*/
/*会出现***BROKEN***No.1978520: B, A错误: */
/*会出现***BROKEN***No.1979912: B, B错误:
   是因为toString执行之前 数据竞争导致
* */

@NotThreadSafe
public class Gate {
    private int count=0;
    private String name="Nobody";
    private String address="NoWhere";

    public void pass(String name, String address) {
        this.name = name;
        this.address = address;
        ++count;
        check();
    }

    @Override
    public String toString() {
        return "No."+count+": "+name+", "+address;
    }

    private void check() {
        if(name.charAt(0)!=address.charAt(0)){
            System.out.println("***BROKEN***"+toString());
        }
    }

    public static void main(String[] args) {
        Gate gate=new Gate();
        gate.check();
    }
}
