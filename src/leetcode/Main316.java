package leetcode;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * @author Junho
 * @date 2022/4/9 19:22
 */
public class Main316 {
    public String removeDuplicateLetters(String s) {
        boolean[] isExist = new boolean[26];
        int[] last = new int[26];
        for(int i = 0 ; i < s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }
        String res = "";
        for(int i = 0 ;i < s.length() ;i++){
            if(isExist[s.charAt(i) - 'a'])
                continue;
            while (
                res.length() > 0 &&
                res.charAt(res.length() - 1) > s.charAt(i) &&
                last[s.charAt(i) - 'a'] > i
            ){
                isExist[res.charAt(res.length() - 1) - 'a'] = false;
                res = res.substring( 0 , res.length() - 1);
            }
            isExist[s.charAt(i) - 'a'] = true;
            res += s.charAt(i);
        }
        return res;
    }
}
