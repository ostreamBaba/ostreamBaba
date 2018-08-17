package com.dataStructure.nowCoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ Create by ostreamBaba on 18-8-17
 * @ ÃèÊö
 */
public class _32 {

    ArrayList<ArrayList<Integer>> list;
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        list=new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        list.add(new ArrayList<Integer>());
        for (int i = 1; i <= S.length; i++) {
            dfs(0,i,new ArrayList<Integer>(),S);
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    private void dfs(int st,int ed,ArrayList<Integer> l,int[] S){
        if(ed==-1){
            return;
        }
        if(ed==0){
            list.add( (ArrayList<Integer>) l.clone() );
        }
        for (int i = st; i < S.length; i++) {
            l.add(S[i]);
            dfs(i+1,ed-1,l,S);
            l.remove(l.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] s={1,2};
        System.out.println(new _32().subsets(s));
    }
}
