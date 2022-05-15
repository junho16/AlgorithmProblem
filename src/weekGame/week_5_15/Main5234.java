package weekGame.week_5_15;

import java.util.ArrayList;
import java.util.List;

/**
 * 5234. 移除字母异位词后的结果数组 显示英文描述
 * 给你一个下标从 0 开始的字符串 words ，其中 words[i] 由小写英文字符组成。
 *
 * 在一步操作中，需要选出任一下标 i ，从 words 中 删除 words[i] 。其中下标 i 需要同时满足下述两个条件：
 *
 * 0 < i < words.length
 * words[i - 1] 和 words[i] 是 字母异位词 。
 * 只要可以选出满足条件的下标，就一直执行这个操作。
 *
 * 在执行所有操作后，返回 words 。可以证明，按任意顺序为每步操作选择下标都会得到相同的结果。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。例如，"dacb" 是 "abdc" 的一个字母异位词。
 * @author Junho
 * @date 2022/5/15 10:33
 */
public class Main5234 {
    public static void main(String[] args) {
        String[] strings = new String[]{"abba","baba","bbaa","cd","cd"};
        removeAnagrams(strings);
    }

    public static List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        int[] org = new int[26];
        int[] cur = new int[26];
        for(int i = 0 ; i < words[0].length() ; i++){
            org[words[0].charAt(i) - 'a']++;
        }
//        for(int i = 1 ; i < words.length ; i++){
        res.add(words[0]);
        int i = 1;
        while (i < words.length){
            cur = new int[26];
            for(int j = 0 ; j < words[i].length() ; j++){
                cur[words[i].charAt(j) - 'a']++;
            }
            boolean f = true;
            for(int j = 0 ; j < cur.length ; j++){
                if(cur[j] != org[j]){
                    f = false;
                    break;
                }
            }
            if(!f){
                res.add(words[i]);

            }
            for(int j = 0 ; j < cur.length ; j++){
                org[j] = cur[j];
            }
            i++;
        }
//        for(String s : res ){
//            System.out.println(s);
//        }
        return res;
    }
}
