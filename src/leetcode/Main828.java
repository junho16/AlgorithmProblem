package leetcode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

/**
 * 828. 统计子串中的唯一字符
 * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
 * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
 * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整数。
 * 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
 * @author Junho
 * @date 2022/9/18 21:34
 */
public class Main828 {
    public int uniqueLetterString(String s) {
        // 26个字母在前面出现的位置和从后往前第一次出现的位置
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];

        int[] chidx = new int[26];

//        // 从前往后遍历要将其设置为-1即最前面0的左边一位 从后往前遍历要将其设置为最后面n-1的后一位即n
//        // 因为 假设第一位就是符合要求的字母 则应该取到其左一位
//        Arrays.fill(chidx , -1);
        for(int i = 0; i < s.length() ; i++){
            left[i] = chidx[s.charAt(i) - 'A'];
            chidx[s.charAt(i) - 'A'] = i;
        }

//        Arrays.fill(chidx , s.length());
        for(int i = s.length() - 1 ; i >=0 ; i--){
            right[i] = chidx[s.charAt(i) - 'A'];
            chidx[s.charAt(i) - 'A'] = i;
        }

        int res = 0;
        for(int i = 0; i < s.length() ;i++){
            res += (i - left[i]) * (right[i] - i);
        }
        return res;
    }
}
