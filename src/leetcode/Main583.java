package leetcode;

/**
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 *
 * 每步 可以删除任意一个字符串中的一个字符。
 *
 * @author Junho
 * @date 2022/4/21 19:47
 */
public class Main583 {
    /**
     * dp[i][j]代表word1前i个字符和word2的前j个字符 如果要相等，最短需要删除的字符数
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0 ; i <= word1.length() ; i++){
            dp[i][0] = i;
        }
        for(int i = 0 ; i <= word2.length() ; i++){
            dp[0][i] = i;
        }
        for(int i = 1; i <= word1.length() ;i++){
            for(int j = 1; j <= word2.length() ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                            dp[i - 1][j - 1] + 2
                    );
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
