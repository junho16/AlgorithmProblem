package leetcode;

/**
 * 516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * @author Junho
 * @date 2022/4/21 21:44
 */
public class Main516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        //dp[i][j]表示的是什么？是从i到j之间的最长回文序列的长度
        for(int i = 0; i <= s.length(); i++){
            dp[i][i] = 1;
        }
        //此处顺序不能变 需要保证每一个子问题的求解是正确的
        for (int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < s.length() ; j++){
                if(s.charAt(i) == s.charAt(j) ){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j] , dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
