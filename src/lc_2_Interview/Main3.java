package lc_2_Interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Main3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character , Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        for(int i = 0 , j = 0 ; i < s.length() ; i++){
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0) + 1 );
            while(map.containsKey(s.charAt(i))
                && map.get(s.charAt(i)) > 1 ) {
                int x = map.get(s.charAt(j));
                if(x >= 1){
                    map.put(s.charAt(j) , x - 1 );
                }else{
                    map.put(s.charAt(j) , 0);
                }
                j++;
            }
            res = Math.max(res , i - j + 1);
        }
        return res;
    }
}
