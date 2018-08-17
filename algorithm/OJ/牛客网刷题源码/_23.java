package com.dataStructure.nowCoder;

/**
 * @ Create by ostreamBaba on 18-8-13
 * @ ÃèÊö
 */
public class _23 {

    public int numDistinct(String S, String T) {
        int n=S.length();
        int m=T.length();
        int dp[][]=new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(S.charAt(i-1)==T.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(new _23().numDistinct("rabbbit","rabit"));
    }

}
