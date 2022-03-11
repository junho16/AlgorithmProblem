package leetcode;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 * 这个题目如果是log（m+n）的时间复杂度就必须从一开始就分治，毕竟hard 所以先用一种简单的方式hhh
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class Main4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int idx_1 = 0;
        int idx_2 = 0;
        int idx = 0;
        int[] nums = new int[nums1.length + nums2.length];
        while (idx_1 < nums1.length && idx_2 < nums2.length){
            if(nums1[idx_1] <= nums2[idx_2]){
                nums[idx++] = nums1[idx_1++];
                // idx_1++;
            }else{
                nums[idx++] = nums2[idx_2++];
                // idx_2++;
            }
        }
        while (idx_1 < nums1.length){
            nums[idx++] = nums1[idx_1++];
        }
        while (idx_2 < nums2.length){
            nums[idx++] = nums2[idx_2++];
        }
        int k = nums1.length + nums2.length;
        if(k % 2 == 0)
            return nums[k / 2];
        else
            return nums[k / 2 + 1];
//        for(int i = 0 ; i < nums.length ;i++){
//            System.out.print( nums[i] + " ");
//        }
//        return 0;
    }
}
