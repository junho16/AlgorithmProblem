package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1049. 最后一块石头的重量 II
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 * @author Junho
 * @date 2022/4/14 19:07
 */
public class Main1049 {
    Map<String , Integer> map;
    int[] stones;

    public int lastStoneWeightII(int[] s) {
        map = new HashMap<>();
        stones = s;
        return  dfs(0 , 0 );
    }
    int dfs(int idx , int last){
        if(map.containsKey(idx + " " + last))
            return map.get(idx + " " + last);
        if(idx == stones.length){
//            res = Math.min(res , Math.abs(last));
            return Math.abs(last);
        }
        int a = dfs(idx + 1 , last + stones[idx]);
        int b = dfs(idx + 1 , last - stones[idx]);
        map.put(idx + " " + last , Math.min(a ,b));
        return Math.min(a ,b);
    }
//  下面的方法是dp，但是需要推断出 sum/2 为背包容量的dp比较难以证明，上面的方式就比较清晰明了，传统记忆化搜索
//    public int lastStoneWeightII(int[] stones) {
//        int sum = 0;
//        for(int i = 0 ; i < stones.length ; i++){
//            sum += stones[i];
//        }
//        int sumT = sum;
//        sum = sum / 2;
//        System.out.println(sumT);
//        int[] v = new int[stones.length + 1];
//        for(int i = 0 ;i < stones.length ; i++)
//            v[i+1] = stones[i];
//        // int[] v = new int[stones.length ];
//        // for(int i = 0 ;i < stones.length ; i++)
//        //     v[i] = stones[i];
//        int[][] dp = new int[v.length + 1][sum + 1];
//        for(int i = 1 ; i <= stones.length ; i++){
//            for(int j = 1 ; j <= sum ;j++){
//                dp[i][j] = dp[i-1][j];
//                if(v[i] <= j){
//                    dp[i][j] = Math.max(dp[i-1][j-v[i]]+v[i] , dp[i][j]);
//                }
//            }
//        }
//        System.out.println(dp[stones.length-1][sum-1]);
//        System.out.println(dp[stones.length][sum]);
//        return sumT - 2 * dp[stones.length][sum];
////        int[] f = new int[sum + 1] ;
////        for(int i = 0 ; i < stones.length ; i++){
////            for (int j = sum; j >= stones[i]; j -- ){
////                f[j] = Math.max(f[j], f[j - stones[i]] + stones[i]);
////            }
////        }
////        for(int i  =0  ; i< f.length ; i++){
////            System.out.print( f[i] +" ");
////        }
//    }
}

