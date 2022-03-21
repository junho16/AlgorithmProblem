package lc_2_Interview;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * @author Junho
 * @date 2022/3/19 22:13
 */
public class Main64 {
    /**
     * 正解 DP
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0)
                    continue;
                if(i == 0){
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }else if(j == 0){
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }else{
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j] , grid[i][ j - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }


//    暴搜超时了，还是得用dp，因为一个显著的条件提示：只能向下或者向右移动
//    int[][] grid;
//    boolean[][] flag;
//    int res = Integer.MAX_VALUE;
//    int[] fx_x = {0 , 1 };
//    int[] fx_y = {1 , 0 };
//
//    public int minPathSum(int[][] g) {
//        grid = g;
//        flag = new boolean[g.length][g[0].length];
//        flag[0][0] = true;
//        dfs(0, 0 , grid[0][0]);
//        return res;
//    }
//    public void  dfs(int x , int  y , int sum){
//        if(x == grid.length - 1 && y == grid[0].length - 1){
//            res = Math.min(res , sum);
//            return;
//        }
//        for(int i = 0 ;i < 2; i++){
//            int a = x + fx_x[i];
//            int b = y + fx_y[i];
//            if(a >= 0 && b >= 0 && a < grid.length && b < grid[0].length && !flag[a][b]){
//                flag[a][b] = true;
//                dfs(a , b , sum + grid[a][b]);
//                flag[a][b] = false;
//            }
//        }
//    }
}
