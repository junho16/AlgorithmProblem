package leetcode;

import java.util.Arrays;

/**
 * 378. 有序矩阵中第 K 小的元素
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 */
public class Main378 {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length-1][matrix[0].length-1];
        while (left < right){
            int mid = left + right >> 1;
            int num = 0;
            for(int i = 0; i < matrix.length ; i++){
                for(int j = 0 ; j < matrix[0].length ;j++){
                    if(matrix[i][j] <= mid){
                        num++;
                    }
                }
            }
            if(num < k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        // System.out.print(right+" "+left);
        int[] nums = new int[matrix.length*matrix[0].length];
        int index = 0;
        int n = 0;
        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ;j++){
                if(matrix[i][j] <= left){
                    nums[index++] = matrix[i][j];
                    if(index == k)
                        break;
                }
            }
        }
        Arrays.sort(nums,0,index);
        return nums[index-1];
    }
}
