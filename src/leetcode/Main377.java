package leetcode;

/**
 * 377. 组合总和 Ⅳ
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 * @author Junho
 * @date 2022/4/16 12:03
 */
public class Main377 {
    public int combinationSum4(int[] nums, int target) {
        int[] v = new int[nums.length + 1];
        for(int i = 0 ;i < nums.length ; i++){
            v[i + 1] = nums[i];
        }
        //dp[i][j] ==> 长度为 i 的加和为 j 的种类数
        int[][] dp = new int[target + 1][target + 1];
        dp[0][0] = 1;
        int res = 0;
        for(int i = 1; i <= target ; i++){
            for(int j = 0; j <= target; j++){
                for(int k = 0 ; k < nums.length ; k++){
                    if(j >= nums[k])
                        dp[i][j] += dp[i - 1][j - nums[k]];
                }
            }
            res += dp[i][target];
        }
        return res;

//  这样会有缺陷，举个例子，123在背包问题中代表1个,但是在此处代表6个，这就是差别，因为dp不可以是前i个，而更应该是长度（长度为1、2、3...）价值为k的种类数
//        int[][] dp = new int[nums.length + 1][target + 1];
//        dp[0][0] = 1;
//        for(int i = 1; i <= nums.length ; i++){
//            for(int j = 0; j <= target; j++){
//                for(int k  = 0; k * v[i] <= j ; k++ ){
//                    dp[i][j] += dp[i - 1][j - k * v[i]];
//                }
//            }
//        }
//        return dp[nums.length][target];
    }
}
