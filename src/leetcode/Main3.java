package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author Junho
 * @date 2022/5/27 15:19
 */
public class Main3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring(  "bbbbb"));
        System.out.println(lengthOfLongestSubstring(  "pwwkew"));


    }
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character , Integer> count = new HashMap<>();
        for(int i = 0 ,  j = 0  ; i < s.length(); i++){
            count.put(s.charAt(i) , 1 + count.getOrDefault(s.charAt(i) , 0));
            while (count.get(s.charAt(i)) > 1){
                count.put(s.charAt(j) , count.get(s.charAt(j)) - 1);
                j++;
            }
            res = Math.max(res , i - j + 1);
        }
        return res;
    }
}
