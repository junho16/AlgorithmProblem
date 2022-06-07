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
    boolean[] flag;
    String s;
    List<String> wordDict;
    boolean res = false;
    public boolean wordBreak(String _s, List<String> wt) {
        s = _s;
        wordDict = wt;
        flag = new boolean[s.length() + 1];
        dfs(0);
        return res;
    }

    //从index开始暴搜
    void dfs(int index){
        if(index == s.length()){
            res = true;
            return;
        }
        for(int i = index + 1 ; i <= s.length() ; i++){
            String tmp = s.substring(index , i);
            // 如果此处（i位置）后面没有暴搜过，则搜一下，不然可以直接跳过了 因为如果搜过 要么已经成功了 要么是搜不出解的
            if(wordDict.contains(tmp) && !flag[i]){
                dfs(i);
            }
        }
        // 解释一下，如果到此处了 说明 从index往后是不可能有解的 ，因为如果有解就直接到最后res = true了
        // 也就是说从index开始暴搜只能是false（算是记忆化搜索的一种手段吧）
        flag[index] = true;
    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        boolean[] dp = new boolean[s.length() + 1];
//        dp[0] = true;
//        for(int i = 0 ; i < s.length() ; i++){
//            for(int j = i + 1 ; j < s.length() + 1; j++){
//                String ss = s.substring(i , j);
//                // System.out.println(ss);
//                if(dp[i] && wordDict.contains(ss))
//                    dp[j] = true;
//            }
//        }
//        return dp[s.length()];
//    }
}
