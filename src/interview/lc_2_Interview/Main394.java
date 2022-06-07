package interview.lc_2_Interview;

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
    Stack<String> stack ;
    public String decodeString(String s) {
        stack = new Stack<>();
        for(int i = 0 ; i < s.length() ;  ){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9' ){
                int k = i;
                String num = "";
                while(k < s.length() && s.charAt(k) >= '0' && s.charAt(k) <= '9' ){
                    num += s.charAt(k);
                    k++;
                }
                stack.push(num);
                i = k;
                System.out.println("0");
                sout();
                continue;
            }else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                int k = i;
                String code = "";
                while(k < s.length() && s.charAt(k) >= 'a' && s.charAt(k) <= 'z' ){
                    code += s.charAt(k);
                    k++;
                }
                stack.push(code);
                i = k;
                System.out.println("1");
                sout();
                continue;
            }else if(s.charAt(i) == '['){
                stack.push(s.charAt(i)+"");
                i++;
                System.out.println("2");
                sout();
            }else{
                //此处应该是只剩下 ]
                //以次出栈一个字母串 一个[ 一个数字
                String tmp = "";

                String code = "";
                while (!stack.isEmpty() && !stack.peek().equals("[")){
                    code = stack.pop() + code;
                }

                stack.pop();// [
                Integer count = Integer.parseInt(stack.pop());
                for(int k = 0 ; k < count ; k++ ){
                    tmp += code;
                }
                while (!stack.isEmpty() && !stack.peek().equals("[")){
                    tmp = stack.pop() + tmp;
                }
                stack.push(tmp);
                i++;
                System.out.println("3");
                sout();
            }
        }
        String res = "";
        while (!stack.isEmpty()){
            res = stack.pop() + res;
        }
        return res;
    }
    public void sout(){
        for(String s : stack){
            System.out.print(s + " ");
        }
        System.out.println("\n===========");
    }
}
