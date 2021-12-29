package leetcode;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class Main200 {
    static boolean[][] flag;
    static char[][] map;
    int row;
    int col;
    public int numIslands(char[][] grid) {
        int res = 0;
        map = grid;
        row = grid.length;
        col = grid[0].length;
        flag = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(!flag[i][j] && grid[i][j] == '1'){
                    res++;
                    dfs(i , j);
                }
            }
        }
        return res;
    }
    void dfs(int x , int y){
        flag[x][y] = true;
        int[] fx_x = {0,1,0,-1};
        int[] fx_y = {1,0,-1,0};
        for(int i = 0 ; i < 4; i++){
            int xx = x + fx_x[i];
            int yy = y + fx_y[i];
            if(xx>=0 && yy>=0 && xx<row && yy < col
                    && !flag[xx][yy] && map[xx][yy] == '1')
                dfs(xx, yy);
        }
    }
}

/**
 [
 ["1","1","0","0","0"],
 ["1","1","0","0","0"],
 ["0","0","1","0","0"],
 ["0","0","0","1","1"]
 ]
 */
