package leetcode;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * @author Junho
 * @date 2022/4/14 14:26
 */
public class Main416 {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int i =0 ; i < nums.length ;i++){
            sum += nums[i];
        }
        if(sum % 2 == 0 ){
            sum = sum / 2;
        }else{
            return false;
        }

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for(int i = 0; i < nums.length ;i++){
            for(int j = sum ; j >= nums[i] ; j--){
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}