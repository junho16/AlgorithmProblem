package leetcode;

/**
 * 简单模拟题目
 *
 * 748. 最短补全词
 * 给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
 *
 * 补全词 是一个包含 licensePlate 中所有的字母的单词。在所有补全词中，最短的那个就是 最短补全词 。
 *
 * 在匹配 licensePlate 中的字母时：
 *
 * 忽略 licensePlate 中的 数字和空格 。
 * 不区分大小写。
 * 如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
 *
 * 请你找出并返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 最靠前的 那个。
 */
public class Main748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnt = getArr(licensePlate);
        String res = "";
        for(int i = 0; i < words.length ; i++){
            //boolean flag = false;
            int[] cur = getArr(words[i]);
            for(int j = 0 ; j < 26 ; j++ ){
                if(j == 25 && cur[j] >= cnt[j]){
                    res = words[i];
                    return res;
                }
                if(cur[j] < cnt[j])
                    break;
            }
        }
        return res;
    }
    public int[] getArr(String s){
        s = s.toLowerCase();
        //System.out.print(s);
        int[] arr = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                arr[s.charAt(i) - 'a']++;
        }
        return arr;
    }
}
