package lc_2_Interview;

import java.util.Map;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class Main5 {
    public static void main(String[] args) {
        System.out.println("123456".substring(1,3));
    }
    public String longestPalindrome(String s) {
//        int res = Integer.MIN_VALUE;
        String res = "";
        for(int i = 0 ; i < s.length() ;i++){
            int l = i - 1 , r = i + 1;
            while (l > 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
//            res = Math.max(res , r - l + 1 );
            res = s.substring(l , r + 1 );
            l = i;
            r = i + 1;
            while (l > 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            res = s.substring(l , r + 1);
        }
        return res;
    }
}
