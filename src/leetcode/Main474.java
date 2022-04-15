package leetcode;

/**
 * 474. 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * @author Junho
 * @date 2022/4/15 15:57
 */
public class Main474 {
    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{
                "10", "0", "1"
        } , 1 , 1));
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        int[] v_0 = new int[strs.length + 1];
        int[] v_1 = new int[strs.length + 1];
        for(int i = 0 ;i < strs.length ;i++){
            int n_0 = 0;
            int n_1 = 0;
            for(int j = 0 ; j < strs[i].length() ; j++){
                if(strs[i].charAt(j) == '1')
                    n_1++;
                else
                    n_0++;
            }
            v_0[i + 1] = n_0;
            v_1[i + 1] = n_1;
        }
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for(int i = 1; i <= strs.length ; i++){
            for(int j = 0; j <= m  ; j++){
                for(int k = 0; k <= n ; k++){
                    dp[i][j][k] = dp[i - 1][j][k];
                    if(j >= v_0[i] && k >= v_1[i]){
                        dp[i][j][k] = Math.max(dp[i][j][k] , dp[i - 1][j - v_0[i]][k - v_1[i]] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}