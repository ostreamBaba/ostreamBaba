package com.dataStructure.nowCoder;

/**
 * @ Create by ostreamBaba on 18-8-17
 * @ √Ë ˆ
 */
public class _31 {
    public int minDistance(String word1, String word2) {
        char[] c1=word1.toCharArray();
        char[] c2=word2.toCharArray();
        int n=c1.length;
        int m=c2.length;
        int[][] dp=new int[n+1][m+1];
        for (int i = 0; i <= m; i++) {
            dp[0][i]=i;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0]=i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(c1[i-1]==c2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j]+1,Math.min(dp[i-1][j-1]+1,dp[i][j-1]+1));
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1="abc";
        String s2="abccd";
        System.out.println(new _31().minDistance(s1,s2));
    }
}
