package offer2;

/**
 * 快速判断两个字符串是否有重复字母（二进制运算）当然 时间复杂度当然也是O(n^2)
 *
 * 剑指 Offer II 005. 单词长度的最大乘积
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时
 * 它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。
 * 如果没有不包含相同字符的一对字符串，返回 0。
 *
 * @author Junho
 * @date 2022/6/21 18:36
 */
public class Main005 {
    public int maxProduct(String[] words) {
        int[] map = new int[words.length];
        for(int i = 0; i < words.length ; i ++){
            int tmp = 0;
            for(int k = 0 ; k < words[i].length() ; k++){
                tmp = tmp | 1 << (words[i].charAt(k) - 'a');
            }
            map[i] = tmp;
        }
        int res = 0;
        for(int i = 0 ;i < words.length ; i++){
            for(int j = i + 1; j < words.length ; j++){
                if((map[i] & map[j]) == 0){
                    res = Math.max(res , words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
