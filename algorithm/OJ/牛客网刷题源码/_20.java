package com.dataStructure.nowCoder;

    import java.util.Arrays;

/**
 * @ Create by ostreamBaba on 18-8-12
 * @ ÃèÊö
 */
public class _20 {

    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        for (int j = n-2; j >= 0; --j) {
            if(ratings[j]>ratings[j+1]&&dp[j]<=dp[j+1]){
                dp[j]=dp[j+1]+1;
            }
        }
        int res=0;
        for (int i = 0; i < n; i++) {
            res+=dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a=new int[]{4,2,3,4,1};
        System.out.println(new _20().candy(a));
    }

}
