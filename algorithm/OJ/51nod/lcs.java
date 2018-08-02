package com.dataStructure.dp;

import java.io.IOException;
import java.util.Scanner;

/**
 * @ Create by ostreamBaba on 18-8-2
 * @ √Ë ˆ
 */
public class lcs {

    public static String LCS(String s1,String s2){
        char[] x=s1.toCharArray();
        char[] y=s2.toCharArray();

        int n=x.length;
        int m=y.length;
        int[][] dp=new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            dp[i][0]=0;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i]=0;
        }
        dp[0][0]=0;
        //Arrays.fill(dp,0);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(x[i-1]==y[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        //return dp[n][m];

        //¥Ú”°lcs
        StringBuilder sb=new StringBuilder();
        while (n>0&&m>0){
            if(x[n-1]==y[m-1]){
                sb.append(x[n-1]);
                --n;
                --m;
            }else if(dp[n-1][m]>=dp[n][m-1]){
                --n;
            }else{
                --m;
            }
        }
        sb.reverse();
        return sb.toString();

    }

    public static void main(String[] args) throws IOException {
        Scanner cin=new Scanner(System.in);
        String s1=cin.next();
        String s2=cin.next();
        System.out.println(LCS(s1,s2));
    }

}
