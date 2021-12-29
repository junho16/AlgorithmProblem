package leetcode;

import java.nio.file.ProviderNotFoundException;

/**
 * 695. 岛屿的最大面积
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class Main695 {
    public boolean flag[][];
    public int[][] map;
    public int m;
    public int n;
    public int num = 0;
    public int res = 0;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        map = grid;
        flag = new boolean[grid.length][grid[0].length];
        flag[0][0] = true;
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ;j < n ;j++){
                if(!flag[i][j] && map[i][j] == '1'){
                    res = Math.max(res , num);
                    num = 0;
                    dfs(i , j);
                }
            }
        }
        return res;
    }
    void dfs(int x , int y){
        if(x > m || x < 0 || y > n || y < 0)
            return;
        num++;
        flag[x][y] = true;
        int[] fx_x = {0,1,-1,0};
        int[] fx_y = {1,0,0,-1};
        for(int i = 0 ; i < 4; i++ ){
            int xx = i + fx_x[i];
            int yy = i + fx_y[i];
            if(xx < m && xx >= 0 && yy >=0 && yy <= n && map[xx][yy] == '1' && !flag[xx][yy]){
                dfs(xx , yy);
            }
        }
    }
}
