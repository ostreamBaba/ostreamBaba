package com.dataStructure.nowCoder;

import java.util.Arrays;

/**
 * @ Create by ostreamBaba on 18-8-13
 * @ ÃèÊö
 */
public class _22 {

    static boolean[][] f;
    static int[] dp;
    static int max=0x7FFFFFF;

    public int minCut(String s) {
        int len=s.length();
        f=new boolean[len+1][len+1];
        for (int i = 0; i < len; i++) {
            f[i][i]=true;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i-1; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    if(j+1==i){
                        f[j][i]=true;
                    }else {
                        f[j][i]=f[j+1][i-1];
                    }
                }
            }
        }

        dp=new int[len+1];
        Arrays.fill(dp,0x3FFFFFF);
        dp[len]=-1;

        for (int i = len-1; i >= 0; --i) {
            for (int j = i; j < len; j++) {
                if(f[i][j]){
                    dp[i]=Math.min(dp[i],dp[j+1]+1);
                }
            }
        }

        return dp[0];

    }


    /*private static void dfs(int pos,int count){
        if(pos==-1){
            max=Math.min(max,count);
        }
        for (int i = 0; i <= pos; i++) {
            if(dp[i][pos]&&count+1<max){
                if(i-1==-1){
                    dfs(i-1,count);
                }else{
                    dfs(i-1,count+1);
                }
            }
        }
    }*/

    public static void main(String[] args) {
        String s="abbab";
        System.out.println(new _22().minCut(s));
    }

}
