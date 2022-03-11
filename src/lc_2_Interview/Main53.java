package lc_2_Interview;

/**
 * 可以认为是双指针，这个题目 你想一下 code精妙之处在于 取last在不断更新而且是保证其非负 如果出现负数 ，则去当前值为last就好了
 * 再用last和res取最大值，
 * 看起来code还是比较精妙的
 *
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * @author wjh
 */
public class Main53 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int  i = 0 , last = 0 ; i < nums.length ; i++){
            last = nums[i] + Math.max(0 , last);
            res = Math.max(res , last);
        }
        return res;
    }
}
