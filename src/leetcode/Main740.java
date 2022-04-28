package leetcode;

/**
 * 打家劫舍变种
 * dp[i] 代表的是 选0~i之间的数可以获得的最大点数
 * 实际上 不能选择i-1和i+1就相当于不能打劫相邻的人家 可以选择 删除遍历到的元素或者不删==》这样考虑就相当于打家劫舍了
 *
 * 740. 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * @author Junho
 * @date 2022/4/22 10:18
 */
public class Main740 {
    public int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            maxNum = Math.max(maxNum , nums[i]);
        }
        int[] dp = new int[maxNum + 1];
        int[] count = new int[10005];
        for(int i = 0 ; i < nums.length ; i++){
            count[nums[i]]++;
        }
        dp[1] = count[1];
        for(int i = 2 ;i <= maxNum ; i++){
            dp[i] = Math.max(
                    dp[i - 1] , //不删
                    dp[i - 2] + i * count[i]//删除
            );
        }
        return dp[maxNum];
    }
}
