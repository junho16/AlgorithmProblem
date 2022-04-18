package leetcode;

/**
 * 不用dp的一个神奇解法，美其名曰：前缀和分解
 * 先遍历一遍 求出 前半段的最大值，
 * 再从后到前遍历一遍 求出 后半段最大值 与遍历到的位置的前半段加和 ==》最后求出最大值
 *
 *
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author Junho
 * @date 2022/4/16 20:15
 */
public class Main123 {
    public static void main(String[] args) {
        maxProfit(new int[]{
                3,3,5,0,0,3,1,4
        });
    }
    public static int maxProfit(int[] prices) {
        int[] f = new int[prices.length + 1];
        for(int min = Integer.MAX_VALUE ,  i = 1 ; i <= prices.length; i++){
            f[i] = Math.max(f[i - 1] , prices[i - 1] - min);
            min = Math.min(min , prices[i - 1]);
        }
//        for(Integer i : f){
//            System.out.print(i +" ");
//        }
        int res = 0;
        for(int i = prices.length - 1 , max = Integer.MIN_VALUE; i >= 0 ;i-- ){
            max = Math.max(max , prices[i]);
            res = Math.max(res , max - prices[i] + f[i]);
        }
        return res;
    }
}
