package leetcode;

/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 对每一行二分 这样的时间复杂度就是nlog(n)
 * 最好的做法是从右上角开始看，可以做到每次去掉一行或者一列，则时间复杂度为O(m+n)
 */
public class Main240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0 ; i < matrix.length ; i++){
            int l = 0, r = matrix[i].length - 1;
            while (l < r){
                int mid = l + r + 1 >> 1;
                if(target < matrix[i][mid]){
                    r = mid - 1;
                }else{
                    l = mid;
                }
            }
            if(matrix[i][l] == target)
                return true;
        }
        return false;
    }
}
