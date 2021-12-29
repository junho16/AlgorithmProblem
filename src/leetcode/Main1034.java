package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 洪水覆盖 flood fill
 * 我第一次感觉读懂题意是那么的重要 cao！
 * 1034. 边界着色
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 *
 * 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。
 *
 * 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
 *
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 */
public class Main1034 {
    public int[][] grid;
    public int[][] oriGrid;
    public int row;
    public int col;
    public int m;
    public int n;
    public int color;
    public int target;
    public boolean[][] flag;
    public int[] fx_x = {0 , 1, 0 ,-1};
    public int[] fx_y = {1 , 0, -1 ,0};
    public int[][] colorBorder(int[][] g , int r, int c, int clr) {

        grid = g;
        row = r;
        col = c;

        target = grid[row][col];
        m = grid.length;
        n = grid[0].length;
        color = clr;
        flag = new boolean[m][n];
        oriGrid = new int[m][n];
        for(int i = 0 ; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                oriGrid[i][j] = grid[i][j];
            }
        }
        flag[row][col] = true;
        dfs(row, col);
//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 if(oriGrid[i][j] == target){
//                     //如果等于这个数字 则应该判断其周围是否有相同的
//                     boolean isExistSame = false;
//                     for(int fx = 0; fx < 4 ;fx++){
//                         int a = i + fx_x[fx];
//                         int b = j + fx_y[fx];
// //                        if(a >=0 && a < m && b >= 0 && b < n && !flag[a][b] && grid[a][b] == grid[row][col]){
// //                            isExistSame = true;
// //                        }
//                         if(a >=0 && a < m && b >= 0 && b < n && !flag[a][b] && oriGrid[a][b] == target){
//                             isExistSame = true;
//                         }
//                     }
//                     if(isExistSame){
//                         dfs(i , j);
//                     }
//                 }
//             }
        // }
        return grid;
    }
    public void dfs(int x , int y){

        flag[x][y] = true;

        for(int i =0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(flag[i][j]?"1":"0");
            }
            System.out.println();
        }
        System.out.println();
        for(int i =0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(grid[i][j] );
            }
            System.out.println();
        }
        System.out.println("==============");
        if(x == 0 || x == m-1 || y == 0 || y == n-1){
            System.out.println("!!!1");
            //在方格上就变一下再联通分量的下一个
            grid[x][y] = color;
            for(int fx = 0; fx < 4 ;fx++){
                int a = x + fx_x[fx];
                int b = y + fx_y[fx];
                if(a >=0 && a < m && b >= 0 && b < n  && !flag[a][b] && oriGrid[a][b] == target){
                    System.out.println("===>>"+a+" "+b+"<====");
                    dfs(a , b);
                }
            }
        }else{
            System.out.println("!!!2");
            //在方格内部就先把周围变一下 再继续联通分量的下一步
            boolean isExistSame = false;
            for(int fx = 0; fx < 4 ;fx++){
                int a = x + fx_x[fx];
                int b = y + fx_y[fx];
                if(a >=0 && a < m && b >= 0 && b < n && oriGrid[a][b] != target){
                    isExistSame = true;
                }
            }
            if(isExistSame){
                grid[x][y] = color;
            }
//            for(int fx = 0; fx < 4 ;fx++){
//                int a = x + fx_x[fx];
//                int b = y + fx_y[fx];
//                if(a >=0 && a < m && b >= 0 && b < n && grid[a][b] != target){
//                    grid[x][y] = color;
//                }
//            }
            for(int fx = 0; fx < 4 ;fx++){
                int a = x + fx_x[fx];
                int b = y + fx_y[fx];
                if(a >=0 && a < m && b >= 0 && b < n && !flag[a][b] && oriGrid[a][b] == target){
                    dfs(a , b);
                }
            }
        }
    }
}
