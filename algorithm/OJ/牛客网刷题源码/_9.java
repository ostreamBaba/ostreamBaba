package com.dataStructure.nowCoder;

import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * @ Create by ostreamBaba on 18-8-8
 * @ ÃèÊö
 */
public class _9 {
    /*public boolean Find(int target, int [][] array) {
        int len = array.length;
        int l=0;
        int r=len*len-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            int x=mid/len;
            int y=mid-x*len;
            if(array[x][y]>target){
                r=mid-1;
            }else if(array[x][y]<target){
                l=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }*/

    public boolean Find(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            if(binary(array[i],target)){
                return true;
            }
        }
        return false;
    }

    public boolean binary(int[] arr,int target){
        int l=0;
        int r=arr.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>target){
                r=mid-1;
            }else if(arr[mid]<target){
                l=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _9 Main=new _9();
        int[][] a=new int[2][2];
        a[0][0]=1;
        a[0][1]=2;
        a[1][0]=3;
        a[1][1]=4;
        System.out.println(Main.Find(6,a));

    }

}
