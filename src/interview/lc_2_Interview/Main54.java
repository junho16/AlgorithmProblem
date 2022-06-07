package interview.lc_2_Interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class Main54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList();
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        int[] fx_x = {0,1,-1,0};
        int[] fx_y = {1,0,0,-1};
        flag[0][0] = true;
        for(int i = 0, x = 0 , y = 0 ,fx_i = 0 ; i < matrix.length * matrix[0].length ; i++){
            res.add(matrix[x][y]);
            flag[x][y] = true;
            int a = x + fx_x[fx_i];
            int b = y + fx_y[fx_i];
            int num = 4;
            while (!(a >= 0 && b >= 0 && a < matrix.length && b < matrix[0].length) || flag[a][b]){
                fx_i = (fx_i + 1) % 4;
                a = x + fx_x[fx_i];
                b = y + fx_y[fx_i];
                if(--num == 0)
                    return res;
            }
            x = a;
            y = b;
        }
        return res;
    }
}
