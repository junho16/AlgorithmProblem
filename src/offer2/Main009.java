package offer2;

/**
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * @author Junho
 * @date 2022/7/8 17:55
 */
public class Main009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int j = 0 , res = 0 , sum = 1;
        for(int i = 0 ; i < nums.length ; i++){
            sum *= nums[i];
            while (sum > k && j < i){
                sum /= nums[i++];
            }
            res += j - i + 1;
        }
        return res;
    }
}