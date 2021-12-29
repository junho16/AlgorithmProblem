package leetcode;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 */
public class Main209 {
    public int minSubArrayLen(int target, int[] nums) {
        int res =  Integer.MAX_VALUE;
        int sum = 0 ;
        for(int i = 0 , j = 0  ; i < nums.length ; i++){
            sum += nums[i];
            while(sum - nums[j] >= target){
                sum -= nums[j];
                j++;
            }
            if(sum >= target){
                res = Math.min(res , j - i + 1 );
            }
        }
        if(res == Integer.MAX_VALUE)    return 0;
        else    return res;
    }
}
