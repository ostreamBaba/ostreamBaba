package com.dataStructure.nowCoder;

import java.util.*;

/**
 * @ Create by ostreamBaba on 18-8-17
 * @ ÃèÊö
 */
public class _33 {

    ArrayList<ArrayList<Integer> > list;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        list=new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        list.add(new ArrayList<Integer>());
        for (int i = 1; i <= num.length; i++) {
            dfs(0,i,new ArrayList<Integer>(),num);
        }
        Collections.sort(list,new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> integers, ArrayList<Integer> t1) {
                for (int i = 0; i < integers.size(); i++) {
                    if(i<=t1.size()-1){
                        int t=integers.get(i)-t1.get(i);
                        if(t!=0){
                            return t;
                        }
                    }else{
                        return 1;
                    }
                }
                return -1;
            }
        } );
        return list;
    }

    @SuppressWarnings("unchecked")
    private void dfs(int st,int count,ArrayList<Integer> l,int[] num){
        if(count==-1){
            return;
        }
        if(count==0){
            if(list.contains(l)){
                return;
            }else{
                list.add( (ArrayList<Integer>) l.clone() );
            }
        }
        for (int i = st; i < num.length; i++) {
            l.add(num[i]);
            dfs(i+1,count-1,l,num);
            l.remove(l.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] num={1,2};
        System.out.println(new _33().subsetsWithDup(num));
    }
}
