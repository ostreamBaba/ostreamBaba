package com.dataStructure.nowCoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ Create by ostreamBaba on 18-8-17
 * @ ÃèÊö
 */
public class _34 {

    ArrayList<ArrayList<Integer> > list;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        list=new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        dfs(new ArrayList<Integer>(),num,0);
        return list;
    }

    @SuppressWarnings("unchecked")
    private void dfs(ArrayList<Integer> l,int[] num,int st){
        list.add( (ArrayList<Integer>) l.clone() );
        for (int i = st; i < num.length; i++) {
            if(i>st&&num[i]==num[i-1]){
                continue;
            }
            l.add(num[i]);
            dfs(l,num,i+1);
            l.remove(l.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] num={1,2};
        System.out.println(new _33().subsetsWithDup(num));
    }
}
