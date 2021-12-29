package offer;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Main29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new int[0];
        }
        int[] fx_x = {0 , 1 , 0, -1};
        int[] fx_y = {1 , 0 , -1, 0};
        int fx = 0;
        int index = 0;
        int[] res = new int[matrix.length * matrix[0].length];
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        // System.out.println(matrix.length +" "+matrix[0].length);
        int x = 0 , y = 0;
        while (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !flag[x][y]){
            // System.out.println("======");
            // System.out.println(x+" "+y);
            flag[x][y] = true;
            res[index++] = matrix[x][y];
            if ( x + fx_x[fx] < 0 || x + fx_x[fx] >= matrix.length
                    || y + fx_y[fx] < 0 || y + fx_y[fx] >= matrix[0].length || flag[ x + fx_x[fx] ][ y + fx_y[fx]] ){
                fx = (fx + 1) % 4;
            }
            x = x + fx_x[fx];
            y = y + fx_y[fx];
            // System.out.println(x+" "+y);
            // System.out.println("======");
        }
        return res;
    }
}
