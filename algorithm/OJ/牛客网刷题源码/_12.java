package com.dataStructure.nowCoder;

import java.util.ArrayList;

/**
 * @ Create by ostreamBaba on 18-8-10
 * @ ÃèÊö
 */
public class _12 {

    /*public ArrayList<Integer> printMatrix(int [][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

    }*/

    public static int NumberOf1(int n) {
        int len=0;
        if(n<0){
            n&=Integer.MAX_VALUE;
            ++len;
        }
        while (n>0){
            len+=(n&1);
            n>>=1;
        }
        return len;
    }


    public static void main(String[] args) {
        System.out.println(NumberOf1(-1
        ));
    }
}
