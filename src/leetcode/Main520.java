package leetcode;

/**
 * 520. 检测大写字母
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 */
public class Main520 {
    public boolean detectCapitalUse(String word) {
        int upNum = 0;
        int downNum = 0;
        for(int i = 0 ; i < word.length() ; i++){
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
                upNum++;
            else
                downNum++;
        }
        if(upNum == word.length() || downNum == word.length())
            return true;
        if(upNum == 1 && (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'))
            return true;
        return false;
    }
}
