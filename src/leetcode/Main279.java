package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  这dp个给我整蒙了，而且可以使用拉格朗日四平方定理去做，同时也可以证明此题的解只有1234，不会超过4
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class Main279 {
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1 ; i <= n ;i++){
            for(int j = 1; j * j <= i ; j++ ){
                dp[i] = Math.min(dp[i] ,  dp[i - j * j] + 1);
            }
        }
        return dp[n];




//        int[] f = new int[n+1];
//        Arrays.fill(f,Integer.MAX_VALUE);
//        f[0] = 0;
//        for(int i = 1 ;i <= n ; i++){
//            for(int j = 1 ; j * j <= i ; j++){
//                f[i] = Math.min(f[i], f[i-j*j]+1);
//            }
//        }
//        return f[n];
    }
}
