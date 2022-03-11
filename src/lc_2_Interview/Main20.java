package lc_2_Interview;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Main20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(' ||
                    s.charAt(i) == '[' ||
                    s.charAt(i) == '{'
            ){
                stack.push(s.charAt(i));
            }else{
                switch (s.charAt(i)){
                    case ')': {
                        if(stack.isEmpty() || stack.peek() != '(')
                            return false;
                        else
                            stack.pop();
                        break;
                    }
                    case ']': {
                        if(stack.isEmpty() || stack.peek() != '[')
                            return false;
                        else
                            stack.pop();
                        break;
                    }
                    case '}': {
                        if(stack.isEmpty() || stack.peek() != '{')
                            return false;
                        else
                            stack.pop();
                        break;
                    }
                }

            }
        }
        return stack.isEmpty();
    }
}
