package com.dataStructure.nowCoder;
import java.util.*;

/**
 * @ Create by ostreamBaba on 18-8-11
 * @ √Ë ˆ
 */
public class _17 {

    private static int[][] dp;
    private static ArrayList<String> result;

    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        int len=s.length();
        dp=new int[len+1][len+1];
        for (int i=0;i<len;++i){
            for (int j=0;j<len-i;j++) { //±Ì æ∆´“∆¡ø
                dp[i][j]=check(s.substring(i,i+j+1),dict);
            }
        }
        result=new ArrayList<String>();
        dfs(s.length()-1,new Stack<String>(),s);
        Collections.reverse(result);
        return result;
    }


    @SuppressWarnings("unchecked")
    private static void dfs(int pos, Stack<String> st,String s){
        if(pos==-1){
            Stack<String> re= (Stack<String>) st.clone();
            StringBuilder sb=new StringBuilder();
            while (!re.isEmpty()){
                if(re.size()>1){
                    sb.append(re.pop()).append(" ");
                }else{
                    sb.append(re.pop());
                }
            }
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i <= pos; i++) {
            if(dp[i][pos-i]==1){
                st.push(s.substring(i,pos+1));
                dfs(i-1,st,s);
                st.pop();
            }
        }
    }

    private static int check(String s,Set<String> dict){
        if(dict.contains(s)){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        /*String s="catsanddog";
        String[] dict ={"cat", "cats", "and", "sand", "dog"};
        Set<String> set=new HashSet<String>(Arrays.asList(dict));
        wordBreak(s,set);
        System.out.println(result);*/

        int i=1;
        i=i++;
        System.out.println(i);
    }

}

/*class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    private static int getLen(Point p){
        return (int)(Math.pow(Math.abs(p.x),2)+Math.pow(Math.abs(p.y),2));
    }


    public int maxPoints(Point[] points) {
        int max=0;
        int res=0;
        for (int i = 0; i < points.length; i++) {
            if(points[i].x<0||points[i].y<0){
                continue;
            }
            int current=getLen(points[i]);
            if(max<current) {
                res=i+1;
                max=current;
            }
        }
        return res;
    }*/