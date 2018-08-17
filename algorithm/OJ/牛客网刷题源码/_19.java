package com.dataStructure.nowCoder;

import java.util.Set;

/**
 * @ Create by ostreamBaba on 18-8-12
 * @ ÃèÊö
 */
public class _19 {
    public boolean wordBreak(String s, Set<String> dict) {
        int len=s.length();
        boolean[] dp=new boolean[len+1];
        dp[0]=true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if(dict.contains(s.substring(j,i))&&dp[j]){
                   dp[i]=true;
                }
            }
        }
        return dp[len];
    }
}
