package lc_2_Interview;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class Main300 {
    /**
     * 一个简单的dp
     */
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res , 1);
        for(int i = 0; i < nums.length ;i++){
            for(int j  = 0 ;j < i ; j++){
                if(nums[j] < nums[i])
                    res[i] = Math.max(res[i] , res[j] + 1 );
            }
        }
        int resNum = Integer.MIN_VALUE;
        for(int i = 0 ; i < res.length ;i++ ){
            resNum = Math.max(resNum , res[i]);
        }
        return resNum;
    }
//    public int lengthOfLIS(int[] nums) {
//        int[] res = new int[nums.length];
//        Arrays.fill(res, 1);
//        for(int i = 0 ;i < nums.length ; i++){
//            for(int j = 0; j < i ; j++){
//                if(nums[j] < nums[i])
//                    res[i] = Math.max(res[i] , 1 + res[j]);
//            }
//        }
//        int max = Integer.MIN_VALUE;
//        for(int i = 0 ;i < nums.length ; i++ ){
//            max = Math.max(max , res[i]);
//        }
//        return max;
//    }
}
