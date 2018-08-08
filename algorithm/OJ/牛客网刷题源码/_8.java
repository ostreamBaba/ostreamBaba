package com.dataStructure.nowCoder;

/**
 * @ Create by ostreamBaba on 18-8-7
 * @ ÃèÊö
 */
public class _8 {

    public static int StrToInt(String str) {
        if(str.equals("")){
            return 0;
        }
        char[] chars=str.toCharArray();
        int st=0;
        if(chars[0]=='+'){
            st=1;
        }
        char ch=' ';
        if(chars[0]=='-'){
            st=1;
            ch=chars[0];
        }
        int res=0;
        for (int i = st; i < chars.length; i++) {
            if(chars[i]>='0'&&chars[i]<='9'){
                res=res*10+(int)(chars[i]-'0');
            }else{
                return 0;
            }
        }
        if(ch!=' '){
            res*=-1;
        }
        return res;
    }

    public static void main(String[] args) {
        String var="-123";
        System.out.println(StrToInt(var));
    }
}
