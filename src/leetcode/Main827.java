package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 827. 最大人工岛
 * 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 * 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
 * @author Junho
 * @date 2022/9/18 15:36
 */
public class Main827 {
    public int[] size;
    public int[] p;
    public int m , n;
    public int find(int x){
        if(x != p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }
    public int getIdx(int x , int y){
        return x * n + y;
    }
    public int largestIsland(int[][] grid) {
        m = grid.length ; n = grid[0].length;
        p = new int[m * n];
        size = new int[m * n];
        int[] fx_x = {-1 , 0 , 1 , 0};
        int[] fx_y = {0 , 1 , 0 , -1};
        // 初始化所有的1的陆地和并查集
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] != 0){
                    p[getIdx(i , j)] = getIdx(i , j);
                    size[getIdx(i ,j)] = 1;
                }
            }
        }
        // for(int i = 0 ; i < m * n; i++){
        //     p[i] = i;
        //     size[i] = 1;
        // }

        int res = 1;

        //合并所有的并查集
        for(int i = 0 ; i < m ; i++ ){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    int a = getIdx(i , j);
                    for(int k = 0; k < 4 ; k++) {
                        int x = i + fx_x[k], y = j + fx_y[k];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            int b = getIdx(x, y);
                            // Ssystem.out.println(i+ " " + j + " " + x + " "+ y + " "+ find(a) + " " + find(b));
                            if (find(b) != find(a)) {
                                size[find(b)] += size[find(a)];
                                p[find(a)] = find(b);
                            }
                        }
                    }
                    res = Math.max(res , size[find(a)]);
                    // System.out.println(i+ " " + j + " " + res + " "+  find(a) + " "+ size[find(a)]);
                    // for(int k = 0; k < m * n ;k++ ){
                    //     System.out.println(p[k]+" "+ size[k]);
                    // }
                    // System.out.println( );
                }
            }
        }
        // System.out.print(res);
        // 更改某一个为 1
        for(int i = 0 ; i < m ; i++ ){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] != 1){
                    // 用map防止周围的（比如上面的和下面的）也是联通的
                    Map<Integer , Integer> map = new HashMap<>();
                    for(int k = 0 ; k < 4 ; k++){
                        int x = i + fx_x[k] , y = j + fx_y[k];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            int a = getIdx(x , y);
                            map.put(find(a)  , size[find(a)]);
                        }
                    }
                    int s = 1;
                    for(Map.Entry<Integer , Integer> entry : map.entrySet() ){
                        s += entry.getValue();
                    }
                    res = Math.max(res  , s);
                }
            }
        }
        return res;
    }
}
