package max;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Main53 {
    public int maxSubArray(int[] nums) {
        int res = -999999;
        for(int i = 0 , last = 0 ;i < nums.length ; i++){

            last = nums[i] + Math.max(0 , last);
            res = Math.max(res , last);
        }
        return res;
    }
}
