package leetcode;

import java.util.Arrays;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author Junho
 * @date 2022/4/18 22:22
 */
public class Main309 {
    public int maxProfit(int[] prices) {
        int[][] f = new int[prices.length + 1][4];

        // f[0][0] = 0;
        // 第0天持有的利润?==>为负
        f[0][0] = -prices[0];
        for(int i = 1; i < prices.length ; i++){
//            for(int j = 0; j <= 3 ; j++){
            f[i][0] = Math.max(f[i - 1][0] , f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1] , f[i - 1][2]);
//            }
        }
        return Math.max(f[prices.length - 1][2] ,
                Math.max(f[prices.length - 1][0] , f[prices.length - 1][1]));
    }
}
