package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1592. 重新排列单词间的空格
 * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
 *
 * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
 *
 * 返回 重新排列空格后的字符串 。
 * @author Junho
 * @date 2022/9/17 14:18
 */
public class Main1592 {
    public static void main(String[] args) {
        reorderSpaces("  this   is  a sentence ");
    }
    public static String reorderSpaces(String text) {
        List<String> list = new ArrayList<>();
        int cnt = 0;
        for(int i = 0 ; i < text.length() ; ){
            if(text.charAt(i) == ' '){
                cnt++;
                i++;
            }else{
                int u = i;
                while (u < text.length() && text.charAt(u) >= 'a' && text.charAt(u) <= 'z'){
                    u++;
                }
                list.add(text.substring(i , u));
                i = u;
            }
        }
        if(list.size() == 1){
            String s = list.get(0);
            for(int i = 0 ; i < cnt ; i++){
                s += " ";
            }
            return s;
        }
        int size = cnt / (list.size() - 1);
        int mod = cnt % (list.size() - 1);
        String res = "";
        for(int i = 0 ; i < list.size() ; i++){
            res += list.get(i);
            if(i != list.size() - 1)
                for(int j = 0 ; j < size ; j++)
                    res += " ";
        }
        for(int i = 0 ; i < mod ; i++){
            res += " ";
        }
        return res;
    }
}
