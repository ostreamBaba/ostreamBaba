package com.dataStructure.nowCoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/**
 * @ Create by ostreamBaba on 18-8-12
 * @ √Ë ˆ
 */
public class _21 {

    static int[][] dp;
    static ArrayList<ArrayList<String>> result;

    public ArrayList<ArrayList<String>> partition(String s) {
        result=new ArrayList<ArrayList<String>>();
        int len=s.length();
        dp=new int[len+1][len+1];
        for (int i = 0; i < len; i++) {
            dp[i][i]=1;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    if(j+1==i){
                        dp[j][i]=1;
                    }else{
                        dp[j][i]=dp[j+1][i-1];
                    }
                }
            }
        }
        dfs(s.length()-1,new Stack<String>(),s);
        Collections.sort( result, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> strings, ArrayList<String> t1) {
                for (int i = 0; i < strings.size(); i++) {
                    int re=strings.get(i).compareTo(t1.get(i));
                    if(re>0){
                        return 1;
                    }else if(re==0){
                        continue;
                    }else {
                        return -1;
                    }
                }
                return -1;
            }
        } );
        return result;
    }

    @SuppressWarnings("unchecked")
    private void dfs(int pos, Stack<String> stack,String s){
        if(pos==-1){
              ArrayList<String> strings=new ArrayList<String>();
              Stack<String> st= (Stack<String>) stack.clone();
              while (!st.isEmpty()){
                  strings.add(st.pop());
              }
              result.add(strings);
              return;
        }

        for (int i = 0; i <= pos; i++) {
            if(dp[i][pos]==1){
                stack.push(s.substring(i,pos+1));
                dfs(i-1,stack,s);
                stack.pop();
            }
        }

    }

    public static void main(String[] args) {
        String s="fff";
        new _21().partition(s);
        System.out.println(result);
    }

}
