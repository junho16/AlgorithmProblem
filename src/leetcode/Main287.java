package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * 进阶：O(n)的时间复杂度
 */
public class Main287 {
    /**
     * 通过寻找链表中环的方式 时间复杂度为O（n）
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
         int a = 0;
         int b = 0;
         while (true){
             a = nums[a];
             b = nums[nums[b]];
             if (a == b){
                 a = 0;
                 while (a != b){
                     a = nums[a];
                     b = nums[b];
                 }
                 return a;
             }
         }
    }


    /**
     * 通过排序的方式 时间复杂度为O（nlogn）
     * @param nums
     * @return
     */
    public int findDuplicates(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums , 0 , nums.length);
        for(int i = 1 ; i < nums.length ; i ++ ){
            if(nums[i - 1 ] == nums[i])
                return nums[i];
        }
        return 0;

    }
}
