package lc_2_Interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 单调栈系列 变体
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class Main316 {
    public String removeDuplicateLetters(String s) {
        String res = "";
//        Map<Character , Boolean> isExist = new HashMap();
        boolean[] isExist = new boolean[32];
        int[] last = new int[32];
        for(int i = 0; i < s.length() ; i++)
            last[s.charAt(i) - 'a'] = i;
        for(int i = 0; i < s.length() ;i++){
            if(isExist[s.charAt(i) - 'a']){
                continue;
            }
            while (
                res.length() > 0
                && s.charAt(i) < res.charAt(res.length()-1)
                && i < last[res.charAt(res.length()-1)- 'a']
            ){
                isExist[res.charAt(res.length() - 1) - 'a'] = false;
                res = res.substring(0 , res.length() - 1);
            }
            res += s.charAt(i);
            isExist[s.charAt(i) - 'a'] = true;
        }
        return res;
    }
}
