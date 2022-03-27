package leetcode;

import java.util.Arrays;

/**
 * 343. 整数拆分
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 * @author Junho
 * @date 2022/3/24 22:51
 */
public class Main343 {
    /**
     *  简单说一下整体的思路：
     *  即需要求出所有的 F（n-i）* i 的哪一个最大，假设，递归的都没有（n-i）大，则直接乘以（n-i）
     */
    int[] map;
    int n ;
    public int integerBreak(int nn) {
        n = nn;
        map = new int[n+1];
        Arrays.fill(map , -999);
        return dfs(n);
    }
    int dfs(int n){
        if(n == 2){
            return 1;
        }
        int res = 0;
        if(map[n] != -999){
            return map[n];
        }
        for(int i = 1 ; i <= n ; i++ ){
            res = Math.max(res , Math.max(dfs(n - i) * i , (n - i) * i));
        }
        map[n] = res;
        return res;
    }
}
