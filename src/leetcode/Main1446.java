package leetcode;

/**
 * 1446. 连续字符
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 *
 * 请你返回字符串的能量。
 */
public class Main1446 {
    public int maxPower(String s) {
        int res = 1;
        int len = 1;
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                len++;
            }else{
                len = 1;
            }
            res = Math.max(res , len);
        }
        return res;
    }
}
