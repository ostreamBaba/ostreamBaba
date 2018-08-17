package com.dataStructure.nowCoder;

import java.util.Scanner;

/**
 * @ Create by ostreamBaba on 18-8-11
 * @ ÃèÊö
 */
public class _13 {

    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int t=cin.nextInt();
        int[] sum=new int[t+1];
        for (int i = 1; i <= t; i++) {
            int k=cin.nextInt();
            sum[i]=sum[i-1]+k;
        }
        int q=cin.nextInt();
        int[] qq=new int[q];
        int[] res=new int[q];
        for (int i = 0; i < q; i++) {
            qq[i]=cin.nextInt();
            int rr=lowerBound(sum,1,sum.length,qq[i]);
            if(rr>t){
                rr=t;
            }
            res[i]=rr;
        }
        for (int i = 0; i < q; i++) {
            System.out.println(res[i]);
        }
    }

    public static int lowerBound(int[] nums,int l,int r,int v){
        while(l<r){
            int m = l + (r - l) / 2;
            if(nums[m] >= v) r = m;
            else if(nums[m] < v) l = m+1;
        }
        return l;
    }

    public static int upperBound(int[] nums,int l,int r,int v){
        while(l<r){
            int m = l + (r - l) / 2;
            if(nums[m] <= v) l = m+1;
            else if(nums[m] > v) r = m;
        }
        return l;
    }

}
