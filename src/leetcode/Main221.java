package leetcode;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class Main221 {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int[][] f = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < matrix.length ;i++){
            for(int j = 0 ; j < matrix[0].length ;j++){
                /**
                 * 这里需要注意，这里必须将所有的元素都遍历一遍，34行res = Math.max(res , f[i][j]);需要使用。
                 */
                if(matrix[i][j] == '1') f[i][j] = 1;
            }
        }
        // for(int i = 0 ; i < matrix[0].length ;i++){
        //     f[0][i] = 1;
        // }
        // for(int j = 0 ; j < matrix.length ;j++){
        //     f[j][0] = 1;
        // }
        for(int i = 0 ; i < matrix.length ;i++){
            for(int j = 0 ; j < matrix[0].length ;j++){
                // if(f[i][j] == 1){
                if(i>0 && j >0 && f[i][j] == 1){
                    f[i][j] = Math.min(Math.min(f[i-1][j] , f[i][j-1]) , f[i-1][j-1])+1;
                }
                /**
                 * 此处需要注意，需要放在if外面，因为边界也需要考虑，需要计算一下
                 */
                res = Math.max(res , f[i][j]);
            }
        }
        // for(int i = 0 ; i < f.length ;i++){
        //     for(int j = 0; j < f[0].length ; j++){
        //         System.out.print(f[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return res * res;
    }
}


