package leetcode;

/**
 * 423. 从英文中重建数字
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 */
public class Main423 {
    public String originalDigits(String s) {
        int[] num = new int[10], cnt = new int[26];
        for (char ss: s.toCharArray()) {
            cnt[ss - 'a']++;
        }
        num[0] = cnt['z' - 'a'];
        num[2] = cnt['w' - 'a'];
        num[4] = cnt['u' - 'a'];
        num[6] = cnt['x' - 'a'];
        num[8] = cnt['g' - 'a'];
        num[1] = cnt['o' - 'a'] - num[4] - num[0] - num[2];
        num[3] = cnt['h' - 'a'] - num[8];
        num[5] = cnt['f' - 'a'] - num[4];
        num[7] = cnt['s' - 'a'] - num[6];
        num[9] = cnt['i' - 'a'] - num[5] - num[6] - num[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            char x = (char)('0' + i);
            for (int j = 0; j < num[i]; ++j) {
                sb.append(x);
            }
        }
        return sb.toString();
    }
}
