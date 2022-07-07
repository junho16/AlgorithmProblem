package weekGame.week_6_19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 6099. 小于等于 K 的最长二进制子序列
 * 给你一个二进制字符串 s 和一个正整数 k 。
 * 请你返回 s 的 最长 子序列，且该子序列对应的 二进制 数字小于等于 k 。
 * 注意：
 * 子序列可以有 前导 0 。
 * 空字符串视为 0 。
 * 子序列 是指从一个字符串中删除零个或者多个字符后，不改变顺序得到的剩余字符序列。
 *
 * @author Junho
 * @date 2022/6/19 15:05
 */
public class Main6099 {

    String s;
    int k  ;
    int res = 0;
    Map<Integer , Integer> map = new HashMap<>();
    public int longestSubsequence(String s_, int k_) {
        s = s_;
        k = k_;
        dfs(s.length() - 1 , 0 , 0);
        return res;
    }
    void dfs(int idx , int val , int length){
        if(map.containsKey(idx) && map.get(idx) <= val){
            return;
        }
        map.put(idx , val);
        if(idx == -1){
            res = Math.max(res , length);
            return;
        }
        res = Math.max(res , length);
        if(s.charAt(idx) == '0'){
            dfs(idx -1 ,  (val), length + 1);
        }else if(val + Math.pow(2 , length) <= k){
            dfs(idx -1 , (int) (val + Math.pow(2 , length)), length + 1);
        }
        dfs(idx -1 , (val), length);
    }

}
