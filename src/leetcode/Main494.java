package leetcode;

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * @author Junho
 * @date 2022/4/15 16:38
 */
public class Main494 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{
                1,1,1,1,1
        } , 3));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int[] v = new int[nums.length + 1];
        for(int i = 0 ;i < len ; i++){
            v[i + 1] = nums[i];
        }
        int py = 1000;
        int[][] dp = new int[len + 1][2000 + 1];
        dp[0][1000] = 1;
        for(int i = 1 ; i <= len ;i++){
            for(int j = -1000 ; j <= 1000 ; j++){
                if(j + py >= v[i])
                    dp[i][j + py] += dp[i - 1][j - v[i] + py];
                if(j + v[i]+ py <= 2000 )
                    dp[i][j + py] += dp[i - 1][j + v[i]+ py];
            }
        }
        return dp[len][target + py];
    }
}
//真是他哇了的绝妙， 我真的是废物
//if (S < -1000 || S > 1000) return 0;
//int n = a.size(), Offset = 1000;
//vector<vector<int>> f(n + 1, vector<int>(2001));
//f[0][Offset] = 1;
//for (int i = 1; i <= n; i ++ )
//  for (int j = -1000; j <= 1000; j ++ ) {
//      if (j - a[i - 1] >= -1000)
//          f[i][j + Offset] += f[i - 1][j - a[i - 1] + Offset];
//      if (j + a[i - 1] <= 1000)
//          f[i][j + Offset] += f[i - 1][j + a[i - 1] + Offset];
//}
//return f[n][S + Offset];

