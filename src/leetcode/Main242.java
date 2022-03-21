package leetcode;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * @author Junho
 * @date 2022/3/20 22:47
 */
public class Main242 {
    public boolean isAnagram(String s, String t) {
        int[] arr_s = new int[26];
        int[] arr_t = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            arr_s[s.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < t.length() ; i++){
            arr_t[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(arr_s[i] != arr_t[i])
                return false;
        }
        return true;
    }
}