package com.dataStructure.nowCoder;

/**
 * @ Create by ostreamBaba on 18-8-14
 * @ √Ë ˆ
 */
public class _26 {

    public int numDecodings(String s) {
        if(s.length()==0||s.charAt(0)=='0'){
            return 0;
        }
        int n=s.length();
        char[] chars=s.toCharArray();
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;++i){
            if(chars[i-1]>'0'){
                dp[i]=dp[i-1];
            }
            if(chars[i-2]=='1'||(chars[i-2]=='2'&&chars[i-1]<='6'&&chars[i-1]>='0')){
                dp[i]+=dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new _26().numDecodings("101"));
    }

}
