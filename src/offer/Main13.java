package offer;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class Main13 {
    public int k ;
    public int m;
    public int n;
    public boolean[][] flag;
    public int res = 0;
    public int movingCount(int mm, int nn, int kk) {

        m = mm;
        n = nn;
        k = kk;
        flag = new boolean[m][n];
        //在这里要判断一下是否可以进入0 0
        if(k == 0)
            return 1;
        dfs(0 , 0);
        return res;
    }
    void dfs(int x , int y){
        System.out.println(x+" "+y);
        flag[x][y] = true;
        res++;
        int[] fx_x = {0,1,-1,0};
        int[] fx_y = {-1,0,0,1};
        for(int i= 0 ; i < 4 ; i++ ){
            int a = x + fx_x[i];
            int b = y + fx_y[i];
            int num = 0;
            for(int j = 0; j < (a+"").length() ; j++){
                num += ((a+"").charAt(j) - '0');
            }
            for(int j = 0; j < ( b+"").length() ; j++){
                num += ((b+"").charAt(j) - '0');
            }

            if(a >= 0 && a < m && b >= 0 && b < n && !flag[a][b] && num <= k){
                System.out.println(num+"<--num"+a+" "+b);
                dfs(a, b);
            }
        }

    }
}































