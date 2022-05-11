package leetcode;

import java.util.Arrays;

/**
 * 713. 乘积小于 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，
 * 请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 *
 * @author Junho
 * @date 2022/5/5 9:42
 */
public class Main713 {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 2, 3},0));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0 , r = 0 ;
        int res = 0 ,  num = 1;
        while (l <= r && r < nums.length){
            num *= nums[r++];
            if(num >= k){
                while (num >= k && l < r){
                    num /= nums[l++];
                }
            }
//                System.out.println(l + "  " + r);
            res += (r - l);
//                r++;

        }
        return res;
    }
}
