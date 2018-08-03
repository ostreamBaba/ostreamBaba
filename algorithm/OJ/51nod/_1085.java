package com.dataStructure.dp;

import com.dataStructure.InputUtil;

import java.io.*;

/**
 * @ Create by ostreamBaba on 18-8-2
 * @ 背包问题
 */
public class _1085 {

    public static int solution(int n,int W,int[] w,int[] v){
        int[][] dp=new int[n+1][W+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if(j<w[i]){
                    dp[i][j]=dp[i-1][j]; //可以选择
                }else {
                    dp[i][j] = Math.max( dp[i - 1][j], dp[i - 1][j - w[i]] + v[i] );
                }
            }
        }
        return dp[n][W];
    }

    //优化空间复杂度O(NM)->O(M)
    public static int dp(int n,int W,int[] w,int[] v){
        int[] dp=new int[W+2];
        for (int i = 1; i <= n; i++) {
            for (int j = W; j >= w[i]; --j) {
                dp[j]=Math.max(dp[j],dp[j-w[i]]+v[i]);
            }
        }
        return dp[W];

    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(InputUtil.cin());
        //BufferedReader reader=new BufferedReader(new InputStreamReader(System.in),1<<16);
        //BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out),1<<16);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] tmp=reader.readLine().split("\\s+");//空格分割
        int n = Integer.parseInt(tmp[0]);
        int W = Integer.parseInt(tmp[1]);
        int[] w=new int[n+1];
        int[] v=new int[n+1];
        for (int i = 1; i <= n; i++) {
            tmp=reader.readLine().split("\\s+");
            w[i]=Integer.parseInt(tmp[0]);
            v[i]=Integer.parseInt(tmp[1]);
        }
        out.print(dp(n,W,w,v));
        out.flush();
    }

}
