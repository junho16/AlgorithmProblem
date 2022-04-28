package leetcode;

/**
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 * @author Junho
 * @date 2022/4/22 9:53
 */
public class Main1137 {
    public int tribonacci(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        if(n == 0)  return 0;
        if(n == 1 || n == 2)  return 1;
        for(int i = 3 ; i <= n ; i++){
            res[i] = res[i-1] + res[i-2] + res[i-3];
        }
        return res[n];
    }
}
