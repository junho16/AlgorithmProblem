package leetcode;

import java.util.Arrays;

/**
 * 状态机模型dp
 * 设 f (i,j)为已经走了i条边 并 做了 j 笔交易（已经转了j圈）的前提下的最大收益
 * 设 g (i,j)为已经走了i条边 并 正在转第 j 圈（正在进行第j笔交易）的前提下的最大收益
 * 其状态转移图由于画的太好看了，所以存了个笔记在lc
 *
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author Junho
 * @date 2022/4/18 15:45
 */
public class Main188 {

    public int maxProfit(int k, int[] prices) {
        int res = 0;
        if(k >= prices.length / 2){
            for(int i = 0 ; i < prices.length ;i++){
                if(i + 1 < prices.length && prices[i + 1] >= prices[i])
                    res += (prices[i + 1] - prices[i]);
            }
            return res;
        }
        int[][] f = new int[prices.length + 1][k + 1];
        int[][] g = new int[prices.length + 1][k + 1];
        for(int i =0 ;  i < f.length ;i++ ){
            Arrays.fill(f[i] , (int) (-1 * 1e+8));
        }
        for(int i =0 ;  i < g.length ;i++ ){
            Arrays.fill(g[i] , (int) ( -1 * 1e+8));
        }
        f[0][0] = 0;
        for(int i = 1; i <= prices.length ; i++ ){
            for(int j = 0 ; j <= k ; j++){
                f[i][j] = Math.max(f[i - 1][j] , g[i - 1][j] + prices[i - 1]);
                if(j > 0)
                    g[i][j] = Math.max(g[i - 1][j] , f[i - 1][j - 1] - prices[i - 1]);
                else
                    g[i][j] = g[i - 1][j];
                res = Math.max(res , f[i][j]);
            }
//            for(int j = 1 ; j <= k ; j++){
//                f[i][j] = Math.max(f[i-1][j] , g[i-1][j] + prices[i - 1]);
//                g[i][j] = Math.max(g[i - 1][j] , f[i - 1][j - 1] - prices[i - 1]);
//                res = Math.max(res , f[i][j]);
//            }
        }
        return res;
    }
}
