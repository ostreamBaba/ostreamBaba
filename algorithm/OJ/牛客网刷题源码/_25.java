package com.dataStructure.nowCoder;

/**
 * @ Create by ostreamBaba on 18-8-14
 * @ √Ë ˆ
 */
public class _25 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n=s1.length();
        int m=s2.length();
        if(n+m!=s3.length()){
            return false;
        }
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        char[] c3=s3.toCharArray();
        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for (int i = 1; i <= n; i++) {
            dp[i][0]=(c1[i-1]==c3[i-1]);
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i]=(c2[i-1]==c3[i-1]);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j]=dp[i-1][j]&&(c1[i-1]==c3[i+j-1])
                        ||dp[i][j-1]&&(c2[j-1]==c3[i+j-1]);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(new _25().isInterleave("aabcc","dbbca","aadbbbaccc"));
    }

}
