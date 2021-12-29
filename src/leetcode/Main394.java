package leetcode;

import netscape.security.UserTarget;

import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */

public class Main394 {
    static int index = 0;
    public String decodeString(String s) {
        return dfs(s);
    }
    String dfs(String s ){
        String res = "";
        while (index < s.length() && s.charAt(index) != ']'){
            if((s.charAt(index) >= 'a' && s.charAt(index) <= 'z') || (s.charAt(index) >= 'A' && s.charAt(index) <= 'Z') ){
                res += s.charAt(index);
                index++;
            }
            if(s.charAt(index) >= '0' && s.charAt(index) <= '9'){
                //String num_tmp = s.charAt(u)+"";
                String num_tmp = "";
                int k = index;
                while(s.charAt(k) >= '0' && s.charAt(k) <= '9') {
                    num_tmp += s.charAt(k);
                    k++;
                }
                index = k + 1;
                String y = dfs(s);
                for(int i = 0 ; i < Integer.parseInt(num_tmp) ; i++){
                    res += y;
                }
                index++;
            }
        }
        return res;
    }
}
