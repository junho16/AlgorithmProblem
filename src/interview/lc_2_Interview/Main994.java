package interview.lc_2_Interview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 */
public class Main994 {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList();
        int[] fx_x = {0,1,0,-1};
        int[] fx_y = {1,0,-1,0};
        int newOrangeNum = 0;
        int nullNum = 0;
        int res = 0;
        for(int i = 0 ;i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++ ){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    newOrangeNum++;
                }else{
                    nullNum ++;
                }
            }
        }
        if(nullNum == grid.length * grid[0].length)
            return 0;
        int size = 0;
        int num = queue.size();
        while (!queue.isEmpty()){
            size = num;
            num = 0;
            for(int i = 0 ; i < size ;i++ ){
                int x = queue.peek()[0];
                int y = queue.peek()[1];
                queue.poll();
                for(int k = 0; k < 4 ;k++){
                    int a = x + fx_x[k];
                    int b = y + fx_y[k];
                    if(a >= 0 && b >= 0 && a <= grid.length - 1 && b <= grid[0].length - 1 && grid[a][b] == 1){
                        grid[a][b] = 2;
                        queue.add(new int[]{a , b});
                        num++;
                        newOrangeNum--;
                    }
                }
            }
            res++;
            // for(int i = 0 ; i < grid.length ;i++ ){
            //     for(int j =0 ; j < grid[0].length ; j++){
            //         System.out.print(grid[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println("===");
        }
        return  newOrangeNum == 0 ? res-1 : -1;
    }
}
