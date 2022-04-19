package leetcode;

/**
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * @author Junho
 * @date 2022/4/19 10:47
 */
public class Main714 {
    public int maxProfit(int[] prices, int fee) {

        int[][] f =  new int[prices.length + 1][3];
        f[0][1] = -prices[0];
        for(int i = 1; i < prices.length ; i++){

            f[i][0] = Math.max(f[i - 1][0] , f[i - 1][1] + prices[i]  - fee);
            f[i][1] = Math.max(f[i - 1][1] , f[i - 1][0] - prices[i]);

        }
        return Math.max(f[prices.length - 1][0] , f[prices.length - 1][1]);
        
    }
}
