package com.dataStructure.nowCoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @ Create by ostreamBaba on 18-8-5
 * @ √Ë ˆ
 */

public class _3 {
    
    public ArrayList<String> result=new ArrayList<String>();
    public char[] g=new char[10];
    public boolean[] flag=new boolean[10];

    public ArrayList<String> Permutation(String str) {
        if(str.equals("")){
            return new ArrayList<String>();
        }
        char[] chars=str.toCharArray();
        dfs(0,chars);
        Set<String> set=new HashSet<String>(result);
        ArrayList<String> strings=new ArrayList<String>(set);
        Collections.sort(strings);
        return strings;
    }
    
    public void dfs(int y,char[] f){
        if(y==f.length){
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < f.length; i++) {
                sb.append(g[i]);
            }
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < f.length; i++) {
            if(!flag[i]){
                g[y]=f[i];
                flag[i]=true;
                dfs(y+1,f);
                flag[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        _3 main=new _3();
        main.Permutation("aac");
    }

}
