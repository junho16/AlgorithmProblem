package leetcode;

import java.util.Arrays;

/**
 * 462. 最少移动次数使数组元素相等 II
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 *
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 *
 * @author Junho
 * @date 2022/5/19 20:18
 */
public class Main462 {
    public int minMoves2(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        Arrays.sort(nums);
        int res1 = 0;
        int res2 = 0;
        int mid = nums[ nums.length / 2];
        for (int i = 0; i < nums.length ; i++) {
            res1 += Math.abs(nums[i] - mid);
        }
        mid = nums[ nums.length / 2 - 1];
        for (int i = 0; i < nums.length ; i++) {
            res2 += Math.abs(nums[i] - mid);
        }
        return Math.min(res1 , res2);
    }
}