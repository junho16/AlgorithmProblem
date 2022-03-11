package lc_2_Interview;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class Main200 {
    boolean[][] flag;
    char[][] grid;
    int res;
    int[] fx_x = {1, 0 , -1, 0};
    int[] fx_y = {0 , -1 ,0 , 1};
    public int numIslands(char[][] g) {
        res = 0;
        grid = g;
        flag = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ;i++ ){
            for(int j = 0 ; j < grid[0].length ; j++ ){
                if(grid[i][j] == '1' && flag[i][j] == false){
                    dfs(i , j);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(int x ,int y){
        flag[x][y] = true;
        for(int i = 0 ; i < 4 ; i++){
            int a = x + fx_x[i];
            int b = y + fx_y[i];
            if(a >= 0 && b >= 0 && a < grid.length && b < grid[0].length
                    && grid[a][b] == '1' && flag[a][b] == false){
                dfs(a , b);
            }
        }
    }
}
