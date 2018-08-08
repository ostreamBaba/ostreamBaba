package com.dataStructure.nowCoder;

/**
 * @ Create by ostreamBaba on 18-8-7
 * @ ÃèÊö
 */
public class _7 {
    public int JumpFloorII(int target) {
        if(target==1||target==2){
            return target;
        }
        int[] dp=new int[target+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= target; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i]+=dp[i-j];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        _7 main=new _7();
        System.out.println(main.JumpFloorII(2));
    }
}
