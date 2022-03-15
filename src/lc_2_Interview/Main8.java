package lc_2_Interview;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.Stack;

/**
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 */
public class Main8 {
    /**
     * 暴力！给老子暴力！暴力！！！！面向数据编程，使劲暴，cao！
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        int k = 0;
        while (k < s.length() && s.charAt(k) == ' ')
            k++;
        s = s.substring(k , s.length());
        // System.out.print(s);
        if(s.length() == 0)
            return 0;
        boolean isfu = false;
        if(s.charAt(0) == '-'){
            isfu = true;
            s = s.substring(1, s.length());
        }else if(s.charAt(0) == '+')
            s = s.substring(1, s.length());
        Stack<Integer> stack = new Stack<>();
        for(int i  = 0 ; i < s.length() ; i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                stack.add(s.charAt(i) - '0');
            else if(s.charAt(i) == ' ' && !stack.isEmpty())
                break;
                // else if(s.charAt(i) == ' ' && stack.isEmpty())
                //     continue;
            else{
                break;
            }
        }
        // for (Integer i : stack){
        //     System.out.print(i+ " ");
        // }
        int[] tmp = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()){
            tmp[index++] = stack.pop();
        }
        int kk = index - 1 ;
        while ( kk >= 0 && tmp[kk] == 0)
            kk--;
        for(int ki = kk; ki >= 0 ; ki--)
            stack.push(tmp[ki]);

        // System.out.println( );
        // for (Integer i : stack){
        //     System.out.print(i+ " ");
        // }

        long res = 0;
        long pow = 1;

        while (!stack.isEmpty()){
            int i = stack.pop();
            res = res + i * pow;
            pow *= 10;
            if(stack.size() > 1){
                if( stack.peek() == 0 && res + pow  >= Integer.MAX_VALUE)
                    return isfu ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if(res > Integer.MAX_VALUE){
                return isfu ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            // System.out.println(res) ;
        }
        // System.out.print("===>" +res);
        return isfu ? -1 * (int)res : (int)res;
    }
}
