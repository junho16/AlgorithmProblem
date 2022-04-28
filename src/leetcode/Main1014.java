package leetcode;

/**
 * 1014. 最佳观光组合
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 * @author Junho
 * @date 2022/4/22 21:40
 */
public class Main1014 {
    public int maxScoreSightseeingPair(int[] values) {
        /**
         * 问题即 （values[i] + i） + （values[j] - j）的最大值
         * 也就是说：需要记录位置 i 之前的 values[i] + i 的最大值，因为 values[j] - j 可以确定，
         * 而 i 位置一定在 j 位置之前
         */
        int dp = values[0];
        int res = 0;
        for(int i = 1; i < values.length ; i++){
            int num_j = values[i] - i;
            res = Math.max(res , num_j + dp);
            dp = Math.max(dp , values[i] + i);
        }
        return res;
    }
}
