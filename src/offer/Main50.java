package offer;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class Main50 {
    public char firstUniqChar(String s) {
        char ans = ' ';
        int[] chars = new int[26];
        for (char c : s.toCharArray()) chars[c - 'a'] += 1;
        for (char c : s.toCharArray()) if (chars[c - 'a'] == 1) return c;
        return ans;
    }
}
