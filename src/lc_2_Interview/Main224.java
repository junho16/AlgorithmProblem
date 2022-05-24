package lc_2_Interview;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Scanner;
import java.util.Stack;

/**
 * 224. 基本计算器
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 *
 * @author Junho
 * @date 2022/5/23 19:35
 */
public class Main224 {
    public static void main(String[] args) {
//        System.out.println(calculate("1 + 1"));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));

    }
    public static int calculate(String s) {
//        Stack<String> stack = new Stack<>();
//        for(int i = 0 ; i < s.length() ; ){
//            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
//
//                int k = i+1;
//                while (k < s.length() && s.charAt(k) >= '0' && s.charAt(k) <= '9'){
//                    k++;
//                }
////                int num1 = Integer.parseInt(s.substring(i , k));
//
//                stack.add((s.substring(i , k)));
//                i = k;
//
////                while (!stack.isEmpty() && !stack.peek().equals("(") && (stack.peek().equals("+") || stack.peek().equals("-")))
//                while (!stack.isEmpty() && !stack.peek().equals("(") )
//                {
//                    int num1 = Integer.parseInt(stack.pop());
////                    if(stack.peek().equals("+") || stack.peek())
//                    if(stack.isEmpty() || stack.peek().equals("(") ){
//                        stack.add(num1+"");
//                        break;
//                    }
//                    String ch = stack.pop();
//                    int num2 = Integer.parseInt(stack.pop());
//                    if(ch.equals("+"))
//                        stack.add((num2 + num1)+ "");
//                    else
//                        stack.add((num2 - num1) + "");
//
////                    String tmp = stack.pop();
////                    stack.pop();
////                    stack.add(tmp);
//                }
//
//
//            }else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
//                stack.add(s.charAt(i)+"");
//                i++;
//            }else if(s.charAt(i) == '('){
//                stack.add(s.charAt(i)+"");
//                i++;
//            }else if(s.charAt(i) == ')'){
//                while (!stack.peek().equals("(")){
//                    int num1 = Integer.parseInt(stack.pop());
////                    if(stack.peek().equals("+") || stack.peek())
//                    String ch = stack.pop();
//                    int num2 = Integer.parseInt(stack.pop());
//                    if(ch.equals("+"))
//                        stack.add((num2 + num1)+ "");
//                    else
//                        stack.add((num2 - num1) + "");
//                }
//                String tmp = stack.pop();
//                stack.pop();
//                stack.add(tmp);
//                i++;
//            }else{
//                i++;
//            }
//        }
//        return Integer.parseInt(stack.peek());
        return 0;
    }
}
