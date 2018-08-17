package com.dataStructure.nowCoder;
import java.util.ArrayList;

/**
 * @ Create by ostreamBaba on 18-8-17
 * @ ÃèÊö
 */
public class _35 {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> vector=new ArrayList<Integer>();
        for (int i = 0; i < Math.pow(2,n); i++) {
            vector.add((i>>1)^i);
        }
        return vector;
    }
}
