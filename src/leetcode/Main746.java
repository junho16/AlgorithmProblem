package leetcode;

import java.util.concurrent.TimeUnit;

/**
 * 746. 使用最小花费爬楼梯
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 * @author Junho
 * @date 2022/4/13 16:57
 */
public class Main746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] f = new int[cost.length + 1 ];
        f[0] = 0;
        f[1] = 0;
        for(int i = 2 ;i <= cost.length ; i++){
            f[i] = Math.min(
                    (f[i - 1] + cost[i - 1]),
                    (f[i - 2] + cost[i - 2])
            );
        }
        return f[cost.length];
    }
}
