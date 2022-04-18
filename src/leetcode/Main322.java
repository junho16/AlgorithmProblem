package leetcode;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的
 *
 * 数量无限--完全背包，但是需要转化，比如说：假定其数量无限，容积为amount，每件物品的价值已经给出了，没件物品的容量也就是1
 * 求amount下的最小数量达到amount==》所以在后面要给数组除了0位置的数都赋值为max
 */
public class Main322 {
    public static int coinChange(int[] coins, int amount) {
//        int[] f = new int[amount+1];
//        Arrays.fill(f, (int) 1e+8);
//        f[0] = 0;
//        for(int i = 0 ; i < coins.length; i++){
//            for(int j = coins[i]; j <= amount;j++){
//                f[j] = Math.min(f[j] , f[j - coins[i]] + 1);
//            }
//        }
//        if(f[amount] == (int)1e+8){
//            return -1;
//        }else{
//            return f[amount];
//        }



//      以下的做法是正儿八经的完全背包的思想（三维），上面的是经过优化的。
        int[] v = new int[coins.length+1];
        for(int i = 0 ; i < coins.length ;i++)
            v[i + 1] = coins[i];
//        dp表示：截止到第i种硬币（即0~i），凑齐金额为j的最少数量
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0 ; i < dp.length ;i++){
            Arrays.fill(dp[i], (int) 1e+8);
        }
        dp[0][0] = 0;
        for(int i = 1 ; i <= coins.length ; i++){
            for(int j = 0 ; j <= amount; j++){
                for(int k = 0; k * v[i] <= j ; k++ ){
                    dp[i][j] = Math.min( dp[i][j] , dp[i-1][j - k * v[i] ] + k);
                }
            }
        }
        return dp[coins.length][amount] == (int) 1e+8 ? -1 : dp[coins.length][amount] ;
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5} , 11));
    }
}