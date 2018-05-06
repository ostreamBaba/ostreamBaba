package nyoj;

/**
 * @ Create by ostreamBaba on 18-5-7
 * @ 描述
 */

//子状态 F[i][v] 前i件物品装进容量为v的包里的最大价值
//转移方程 F[i][v]=max(F[i-1][v],F[i-1][v-weight]+cost[i]) 选与不选的问题
public class ZeroAndOneBag {
    private static final int M=3;
    private static final int N=5;
    private int[][] bag;
    private int[] weight={0,3,3,2};
    private int[] cost={0,5,10,20};
    private int max(int a,int b){
        return (a)>(b)?(a):(b);
    }
    //时间复杂度:  O(M*N) 空间复杂度 O(M*N)
    public int test(){
        bag=new int[M+1][N+1];
        for(int i=1;i<=M;++i){
            for(int j=weight[i];j<=N;++j){
                bag[i][j]=max(bag[i-1][j],bag[i-1][j-weight[i]]+cost[i]);
            }
        }
        return bag[M][N];
    }
    public static void main(String[] args) {
        ZeroAndOneBag main=new ZeroAndOneBag();
        System.out.println(main.test());
    }
}
