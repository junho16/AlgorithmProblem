package weekGame.week_9_18;

/**
 * 6181. 最长的字母序连续子字符串的长度
 * 字母序连续字符串 是由字母表中连续字母组成的字符串。换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连续字符串 。
 * 例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。
 * 给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。
 * @author Junho
 * @date 2022/9/18 10:36
 */
public class Main6181 {
    public int longestContinuousSubstring(String s) {
        int res = 1;
        for(int l = 0 , r = 1 ; r < s.length() ; ){
            if(s.charAt(r) == (s.charAt(r-1) + 1)){
                r++;
                res = Math.max(res , r - l);
            }else{
                l = r;
                r = r + 1;
            }
        }
        return res;
    }
}
