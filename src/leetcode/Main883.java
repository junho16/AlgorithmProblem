package leetcode;

/**
 * 883. 三维形体投影面积
 * 在 n x n 的网格 grid 中，我们放置了一些与 x，y，z 三轴对齐的 1 x 1 x 1 立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 *
 * 现在，我们查看这些立方体在 xy 、yz 和 zx 平面上的投影。
 *
 * 投影 就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。
 *
 * 返回 所有三个投影的总面积 。
 *
 * @author Junho
 * @date 2022/4/26 10:54
 */
public class Main883 {
    public int projectionArea(int[][] grid) {
        int up = 0;
        int left = 0;
        int front = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            int tmp = 0;
            for(int j = 0; j < grid[0].length ; j++){
                if(grid[i][j] != 0)
                    up++;
                tmp = Math.max(tmp , grid[i][j]);
            }
            left += tmp;
        }
        for(int i = 0 ; i < grid[0].length ; i++){
            int tmp = 0;
            for(int j = 0; j < grid.length ; j++){
                tmp = Math.max(tmp , grid[j][i]);
            }
            front += tmp;
        }
        return up + front + left;
    }
}
