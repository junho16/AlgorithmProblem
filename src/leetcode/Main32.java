package leetcode;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * @author Junho
 * @date 2022/3/24 11:23
 */
public class Main32 {
    /**
     * 思路：左括号入栈，遇到右括号，出栈一个左括号，计算长度
     *  假设栈中没有左括号，说明此右括号之前已经没有一个有效的括号组合，将此括号位置记录，下次计算时用于计算距离最开头括号有效的位置的长度
     *  tip：栈中只记录左括号（因为有个右括号必有一个左括号对应）
     *  如果没有start 可以看下样例：）（）（））==》计算不出4 而是2 因为第二组（）确认有效后，需要和前一组的（）加起来，需要有一个位置记录==。即start
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0 , start = -1 ; i < s.length() ; i++ ){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    start = i;
                }else{
                    stack.pop();
                    if(!stack.isEmpty())
                        //不空
                        res = Math.max(res , i - stack.peek());
                    else
                        res = Math.max(res , i - start);
                }
            }
        }
        return res;
    }
}
