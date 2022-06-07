package interview.lc_2_Interview;

import java.util.Arrays;

/**
 * 困难题 合并数组后排序找中位数属于暴力，其时间复杂度为 nlogn 题目要求为log（m+n）
 * 但是题目要求得时间复杂度为二分做法或者==》（递归找最小的第 k 个数）|| 个人感觉会比较难
 *
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class Main4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int index = 0;
        for(int i = 0 ; i < nums1.length ; i++ ){
            nums[index++] = nums1[i];
        }
        for(int i = 0 ; i < nums2.length ; i++ ){
            nums[index++] = nums2[i];
        }
        Arrays.sort(nums , 0 , nums.length);
        if(nums1.length + nums2.length % 2 == 0){
            return (nums[(nums1.length + nums2.length) / 2] + nums[(nums1.length + nums2.length) / 2 - 1] ) / 2.0;
        }else{
            return nums[(nums1.length + nums2.length) / 2] * 1.0;
        }
    }
}
