package leetcode;

import java.util.Stack;

/**
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 */
public class Main227 {
    public int calculate(String s) {
        s = s.replace(" ","");
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        for(int i= 0 ; i < s.length() ;i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                int k = i;
                while( k < s.length() && s.charAt(k) >= '0' && s.charAt(k) <= '9'){
                    k++;
                }
                int num = Integer.parseInt(s.substring(i , k));
                numStack.add(num);
                i = k-1;
            }else {
                char idxChar = s.charAt(i);
                if(!charStack.isEmpty()){
                    char peekChar = charStack.peek();
                    // System.out.println("---"+ compare(idxChar , peekChar)+"---");
                    while(!charStack.isEmpty() && compare(idxChar , charStack.peek()) != 1  ){
                        int x = numStack.pop();
                        int y = numStack.pop();
                        char opt = charStack.pop();
                        if(opt == '+'){
                            numStack.add(x + y);
                        }else if(opt == '-'){
                            numStack.add(y - x);
                        }else if(opt == '*'){
                            numStack.add(x * y);
                        }else if(opt == '/'){
                            numStack.add(y / x);
                        }

                    }
                }
                charStack.add(idxChar);


            }
        }
        // for(Character c : charStack){
        //     System.out.print(c+" ");
        // }
        // for(Integer c : numStack){
        //     System.out.print(c+" ");
        // }
        while(!charStack.isEmpty()){
            int x = numStack.pop();
            int y = numStack.pop();
            char opt = charStack.pop();
            if(opt == '+'){
                numStack.add(x + y);
            }else if(opt == '-'){
                numStack.add(y - x);
            }else if(opt == '*'){
                numStack.add(x * y);
            }else if(opt == '/'){
                numStack.add(y / x);
            }
        }
        return numStack.pop();
    }
    public int compare(char idxChar , char peekChar){
        int idxNum = 0;
        if(idxChar == '*' || idxChar == '/'){
            idxNum = 1;
        }
        int peekNum = 0;
        if(peekChar == '*' || peekChar == '/'){
            peekNum = 1;
        }
//        1==>当前优先级大 计算 || 0==》相等 入栈 || -1==》当前优先级小 入栈
        return idxNum - peekNum  ;

    }

}