package com.dataStructure.dp;

import java.util.Scanner;

/**
 * @ Create by ostreamBaba on 18-8-2
 * @ 最大子段和
 */
public class _1049 {

    public static long solution(int[] arr){
        long result=0;
        long s=0;
        for (int i = 0; i < arr.length; i++) {
            s+=arr[i];
            if(s>0){
                result=Math.max(result,s);
            }else {
                s=0;
            }
        }
        return result;
    }

    public static long solution1(int[] arr){
        long[] add=new long[arr.length];
        long[] res=new long[arr.length];
        add[0]=0;
        res[0]=0;
        for (int i = 1; i < arr.length; i++) {
            add[i]=Math.max(arr[i],arr[i]+add[i-1]); //保存当前累加的最大值
            res[i]=Math.max(add[i],res[i-1]);//保存历史的最大值
        }
        return res[arr.length-1];
    }

    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int t=cin.nextInt();
        int[] arr=new int[t+1];
        for (int i = 1; i <= t; i++) {
            arr[i]=cin.nextInt();
        }
        System.out.println(solution1(arr));
    }

}
