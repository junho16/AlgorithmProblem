package leetcode;

/**
 * 318. 最大单词长度乘积
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 */
public class Main318 {
    public int maxProduct(String[] words) {
        int[] flag = new int[words.length];
        for(int i =  0; i < words.length ;i++){
            char[] chars = words[i].toCharArray();
            int sum = 0;
            for(int j = 0; j < chars.length ;j++){
                sum |= 1 << (chars[j] - 'a');
            }
            flag[i] = sum;
        }
        int res = 0;
        for(int i = 0 ; i < words.length ;i++){
            for(int j = i; j < words.length ;j++){
                if((flag[i] & flag[j] ) == 0 )
                    res = Math.max(res , words[i].length() * words[i].length()  );
            }
        }
        return res;
    }
}
