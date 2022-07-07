package weekGame.week_6_19;

import java.util.HashSet;
import java.util.Set;

/**
 * 5242. 兼具大小写的最好英文字母 显示英文描述
 * 给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
 * 最好 英文字母的大写和小写形式必须 都 在 s 中出现。
 * 英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现。
 * @author Junho
 * @date 2022/6/19 11:24
 */
public class Main5242 {
    public String greatestLetter(String s) {
        int[][] res = new int[26][2];
        String returnRes = "";
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                res[s.charAt(i) - 'a'][0]++;
            }
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                res[s.charAt(i) + 32 - 'a'][1]++;
            }
        }
        for(int i = 0 ; i < 26 ;i++){
            if(res[i][0] >= 1 && res[i][1] >= 1){
                returnRes = String.valueOf('A'+i);
            }
        }
        return returnRes;
    }
}
