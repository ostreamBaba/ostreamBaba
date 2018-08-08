package com.dataStructure.nowCoder;

/**
 * @ Create by ostreamBaba on 18-8-6
 * @ ÃèÊö
 */
public class _4 {

    public final static int[] xRow=new int[]{0,0,1,-1};
    public final static int[] yRow=new int[]{1,-1,0,0};
    public static int n=0;
    public static int m=0;
    public static int k=0;
    public boolean[][] visited;

    public int movingCount(int threshold, int rows, int cols) {
        n=rows;
        m=cols;
        k=threshold;
        visited=new boolean[n+1][m+1];
        return dfs(0,0);
    }

    public int help(int x){
        int res=0;
        while (x>0){
            res+=x%10;
            x/=10;
        }
        return res;
    }

    public int dfs(int x,int y){
        int res=0;
        if(x<0||y<0||x>=n||y>=m||(help(x)+help(y))>k||visited[x][y]){
            return 0;
        }else {
            res+=1;
            visited[x][y]=true;
        }
        for (int i = 0; i < 4; i++) {
            x+=xRow[i];
            y+=yRow[i];
            res+=dfs(x,y);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _4().movingCount(15,20,20));
    }

}

