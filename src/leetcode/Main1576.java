package leetcode;

/**
 * 1576. 替换所有的问号
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 *
 * 注意：你 不能 修改非 '?' 字符。
 *
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 *
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 */
public class Main1576 {
    public String modifyString(String s) {
        String res = "";
        for(int i = 0 ;i < s.length() ; i++){
            if(s.charAt(i) == '?'){
                for(char c = 'a' ; c <= 'c' ; c++){
                    if((i < s.length() - 1 && c == s.charAt(i+1) ) || ( i > 0 && c == res.charAt(i-1) ))
                        continue;
                    else
                        res += c;
//                        s = s.substring(0 , i) + c + s.substring(i+1);
                }
            }else{
                res += s.charAt(i);
            }
        }
        return res;
    }
}
