package leetcode;

/**
 * 518. 零钱兑换 II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数
 *
 * @author Junho
 * @date 2022/4/16 11:40
 */
public class Main518 {
    public int change(int amount, int[] coins) {
        int[] v = new int[coins.length + 1];
        for(int i = 0 ;i < coins.length ; i++){
            v[i + 1] = coins[i];
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= coins.length ;i++){
            for(int j = 0; j <= amount ; j++){
                for(int k = 0; k * v[i] <= j; k++ ){
                    dp[i][j] += dp[i - 1][j - k * v[i] ];
                }
            }
        }
        return dp[coins.length][amount];
    }
}