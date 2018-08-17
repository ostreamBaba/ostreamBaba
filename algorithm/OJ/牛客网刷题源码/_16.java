package com.dataStructure.nowCoder;

import java.util.*;

/**
 * @ Create by ostreamBaba on 18-8-11
 * @ √Ë ˆ
 */
public class _16 {

    private static int Evaluate(int a,int b,String op){
        if(op.equals("+")){
            return a+b;
        }else if(op.equals("-")){
            return a-b;
        }else if(op.equals("*")){
            return a*b;
        }else{
            return a/b;
        }
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<Integer>();
        st.push(Integer.parseInt(tokens[0]));
        int ed=tokens.length;
        int s=0;
        String[] temp="+ - / *".split("\\s+");
        Vector<String> vec=new Vector<String>();
        vec.addAll( Arrays.asList(temp));
        int res=0;
        while (!st.isEmpty()){
            if(s<ed-1) {
                if (vec.contains( tokens[++s] )) {
                    int b = st.pop();
                    int a = st.pop();
                    st.push( Evaluate( a, b, tokens[s] ) );
                } else {
                    st.push( Integer.parseInt( tokens[s] ) );
                }
            }else{
                res=st.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] res={"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(res));
    }

}
