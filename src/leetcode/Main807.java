package leetcode;

/**
 * 感觉是一个简单的模拟
 * 实锤了 就特么是一个简单的模拟。。。。
 * 807. 保持城市天际线
 * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。
 *
 * 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。
 */
public class Main807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            int max = 0;
            for(int j = 0; j < grid[0].length ; j++){
                max = Math.max(max , grid[i][j]);
            }
            rowMax[i] = max;
        }
        for(int i = 0 ; i < grid[0].length ; i++){
            int max = 0;
            for(int j = 0; j < grid.length ; j++){
                max = Math.max(max , grid[j][i]);
            }
            colMax[i] = max;
        }
        // for(int i = 0 ; i < rowMax.length ; i++){
        //     System.out.print(rowMax[i]+" ");
        // }
        // System.out.println();
        // for(int i = 0 ; i < colMax.length ; i++){
        //     System.out.print(colMax[i]+" ");
        // }
        // System.out.println();
        int res = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0; j < grid[0].length ; j++){
                int k = Math.min(rowMax[i] , colMax[j]);
                res += (k - grid[i][j]);
            }
        }
        return res;
    }
}
