package com.dataStructure.nowCoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ Create by ostreamBaba on 18-8-12
 * @ √Ë ˆ
 */
public class _18 {

    private static boolean[][] dp;
    private static int len;
    private boolean flag;

    public boolean wordBreak(String s, Set<String> dict) {
        len=s.length();
        dp=new boolean[len+1][len+1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-i; j++) {
                dp[i][j]=dict.contains(s.substring(i,i+j+1));
            }
        }
        dfs(s.length()-1);
        if(flag){
            flag=false;
            return true;
        }
        return false;
    }

    private void dfs(int pos){
        if(flag==true){
            return;
        }
        if(pos==-1){
            flag=true;
        }

        for (int i = 0; i <= pos; i++) {
            if(dp[i][pos-i]){
                dfs(i-1);
            }
        }
    }

    public static void main(String[] args) {
        String s ="a";
        String[] ss={"a"};
        Set<String> dict=new HashSet<String>(Arrays.asList(ss));
        System.out.println(new _18().wordBreak(s,dict));
    }
}
