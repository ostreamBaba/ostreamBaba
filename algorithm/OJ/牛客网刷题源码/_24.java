package com.dataStructure.nowCoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ Create by ostreamBaba on 18-8-14
 * @ ÃèÊö
 */
public class _24 {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n=triangle.size();
        int[][] f=new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> ar=triangle.get(i-1);
            for (int j = 1; j <= i; j++) {
                if(j==1){
                    f[i][j]=ar.get(j-1)+f[i-1][j];
                }else if(j==i){
                    f[i][j]=ar.get(j-1)+f[i-1][j-1];
                }else{
                    f[i][j]=ar.get(j-1)+Math.min(f[i-1][j],f[i-1][j-1]);
                }
            }
        }
        int res=0x3FFFFFF;
        for (int i = 1; i <= n; i++) {
            res=Math.min(res,f[n][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer> > res=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> R1=new ArrayList<Integer>();
        R1.add(-10);
        res.add(R1);
        System.out.println(new _24().minimumTotal(res));
    }
}
