package leetcode;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class Main557 {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        String res = "";
        for(int i = 0 ; i < strings.length ;i++){
            for(int j = strings[i].length() - 1  ; j >= 0; j--){
                res += strings[i].charAt(j);
            }
            res += " ";
        }
        return res.substring(0,res.length()-1);
    }
}
