package com.viscu.something;

/**
 * @ Create by ostreamBaba on 18-6-9
 * @ ÃèÊö
 */
public class test {

    public static String replaceSpace(StringBuffer str) {
        String replaceString="%20";
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(str.charAt(i)==' '){
                result.append(replaceString);
            }else{
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuilder=new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(stringBuilder));
    }
}
