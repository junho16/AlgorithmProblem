package leetcode;

/**
 * 1582. 二进制矩阵中的特殊位置
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 *
 * @author Junho
 * @date 2022/9/18 19:20
 */
public class Main1582 {
    public int numSpecial(int[][] mat) {
        int m = mat.length , n = mat[0].length;
        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                rowSum[i] += mat[i][j];
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                colSum[i] += mat[j][i];
            }
        }
        // for(int j = 0 ; j < m ; j++){
        //     System.out.print(rowSum[j]+" ");
        // }
        // System.out.println( );
        // for(int j = 0 ; j < n ; j++){
        //     System.out.print(colSum[j]+" ");
        // }
        //   System.out.println( );
        int res = 0 ;
        for(int i = 0 ; i < m ; i++ ){
            for(int j = 0 ; j < n ; j++){
                if(0 == rowSum[i] + colSum[j] - 2 * mat[i][j] && mat[i][j] == 1)
                    res++;
            }
        }
        return res;
    }
}