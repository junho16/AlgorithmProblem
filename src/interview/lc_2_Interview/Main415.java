package interview.lc_2_Interview;

import java.util.Stack;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 */
public class Main415 {
    public String addStrings(String num1, String num2) {
        Stack<Integer> stack_1 = new Stack();
        Stack<Integer> stack_2 = new Stack();
        for(int i = 0 ; i < num1.length() ; i++){
            stack_1.push(Integer.parseInt("" + num1.charAt(i)));
        }
        for(int i = 0 ; i < num2.length() ; i++){
            stack_2.push(Integer.parseInt("" + num2.charAt(i)));
        }
        int jw = 0;
        String res = "";
        while ( !stack_1.isEmpty() && !stack_2.isEmpty()){
            int num_1 = stack_1.pop();
            int num_2 = stack_2.pop();
            res += (num_1 + num_2 + jw) % 10;
            jw = (num_1 + num_2 + jw) / 10;
        }
        while( !stack_1.isEmpty()){
            res += (stack_1.peek() + jw) % 10;
            jw = (stack_1.pop()  + jw) / 10;
        }
        while( !stack_2.isEmpty()){
            res += (stack_2.peek() + jw) % 10;
            jw = (stack_2.pop()  + jw) / 10;
        }
        if(jw != 0)
            res += jw;
        //        System.out.println(res);
        return new StringBuilder(res).reverse().toString();
    }
}

