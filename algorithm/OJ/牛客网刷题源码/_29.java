package com.dataStructure.nowCoder;

/**
 * @ Create by ostreamBaba on 18-8-17
 * @ ÃèÊö
 */
public class _29 {

    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}
