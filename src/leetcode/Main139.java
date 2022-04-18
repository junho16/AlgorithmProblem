package leetcode;

import java.util.List;

/**
 * 之前做了一次是暴搜做的，这次使用dp做一下
 * 现在才发现dp是如此的简单，只需要 这样这样再这样 就好了
 *
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * @author Junho
 * @date 2022/4/16 15:40
 */
public class Main139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i + 1 ; j < s.length() + 1; j++){
                String ss = s.substring(i , j);
                // System.out.println(ss);
                if(dp[i] && wordDict.contains(ss))
                    dp[j] = true;
            }
        }
        return dp[s.length()];
    }
}
