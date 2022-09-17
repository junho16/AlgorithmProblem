package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1417. 重新格式化字符串
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 *
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 *
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 *
 * @author Junho
 * @date 2022/8/13 11:19
 */
public class Main1417 {
    public String reformat(String s) {
        List<Character> ch = new ArrayList<>();
        List<Character> num = new ArrayList<>();
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < chars.length ; i++){
            if(chars[i] >= '0' && chars[i] <= '9' ){
                num.add(chars[i]);
            }else{
                ch.add(chars[i]);
            }
        }
        if(Math.abs(ch.size() - num.size()) > 1)
            return "";
        else{
            String res = "";
            int idx = 0;
            for( ; idx < num.size() && idx < ch.size() ; idx++ ){
                res += ch.get(idx);
                res += num.get(idx);
            }
            if(idx < ch.size())
                res += ch.get(idx++);
            if(idx < num.size())
                res = num.get(idx++) + res;
            return res;
        }
    }
}
