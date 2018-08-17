package com.dataStructure.nowCoder;

import java.util.Arrays;

/**
 * @ Create by ostreamBaba on 18-8-16
 * @ √Ë ˆ
 */
public class _28 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][] dp=new int[n][m];
        if(obstacleGrid[0][0]!=1){
            dp[0][0]=1;
        }
        for (int i = 1; i < n; i++) {
            if(obstacleGrid[i][0]==0&&dp[i-1][0]==1){
                dp[i][0]=1;
            }
        }
        for (int i = 1; i < m; i++) {
            if(obstacleGrid[0][i]==0&&dp[0][i-1]==1){
                dp[0][i]=1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(obstacleGrid[i][j]==1){
                    continue;
                }
                if(obstacleGrid[i-1][j]==1&&obstacleGrid[i-1][j]==1){
                    dp[i][j]=0;
                }
                if(obstacleGrid[i-1][j]==1){
                    dp[i][j]=dp[i][j-1];
                }else if(obstacleGrid[i][j-1]==1){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n-1][m-1];

    }
    public static void main(String[] args) {
        int[] a1={1,2,3,4};
        int[] a2=Arrays.copyOf(a1,3);
        System.out.println(Arrays.toString(a1));
        /*int[][] a=new int[1][2];
        a[0][0]=1;
        System.out.println(new _28().uniquePathsWithObstacles(a));*/
    }
}
