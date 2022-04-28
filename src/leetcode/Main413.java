package leetcode;

/**
 * 413. 等差数列划分
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 *
 * 子数组 是数组中的一个连续序列。
 *
 * @author Junho
 * @date 2022/4/23 9:42
 */
public class Main413 {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{2,1,3,4,2,3}));
    }
    public static int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3)
            return 0 ;
        int[] dp = new int[nums.length];
        dp[2] = (nums[2] - nums[1] == nums[1] - nums[0]) ? 1:0;
        int res = dp[2];
        for(int i = 3 ; i < nums.length ; i++){
            for(Integer ii:dp){
                System.out.print(ii +" ");
            }
            System.out.println();
//            if(nums[i-2] + nums[i] == nums[i-1] * 2){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                dp[i] = dp[i-1] + 1;
            }
            res += dp[i];
        }
        return res;
    }
}
