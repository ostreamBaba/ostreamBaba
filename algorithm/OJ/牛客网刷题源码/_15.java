package com.dataStructure.nowCoder;

import java.util.Scanner;

/**
 * @ Create by ostreamBaba on 18-8-11
 * @ √Ë ˆ
 */



public class _15 {

    public String[] str=new String[]{
            "az","za","zz","aa"
    };

    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int a,b,c;
        a=cin.nextInt();
        b=cin.nextInt();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < a; i++) {
            sb.append('n');
        }
        for (int i = 0; i < b; i++) {
            sb.append('m');
        }

    }

    private void dfs(int m,int n){

        if(m==0||n==0){
            return;
        }

        for (int i = 0; i < 4; i++) {

            if(m>1&&m>1){
                dfs(m-1,n-1);
            }
            if(m>2){
                dfs(m-1,n-1);
            }
        }


    }


}
