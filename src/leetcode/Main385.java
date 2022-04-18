package leetcode;

import java.util.*;

/**
 * 八嘎 这题目。。。题面你说清楚点能死？
 *
 * 385. 迷你语法分析器
 * 给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果 NestedInteger 。
 *
 * 列表中的每个元素只可能是整数或整数嵌套列表
 *
 * @author Junho
 * @date 2022/4/15 15:03
 */
public class Main385 {

    public static void main(String[] args) {
        System.out.println(deserialize("[123,[456,[789]]]"));
    }
    public static NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<>();
        Stack<String> stackStr = new Stack<>();
        for(int i = 0 ;i < s.length(); ){
            if(s.charAt(i) == '['){
                stackStr.push("[");
                i++;
            }
            else if(s.charAt(i) == '-' || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){

                int k = i;
                while (k + 1 < s.length() && s.charAt(k + 1) >= '0' && s.charAt(k + 1) <= '9')
                    k++;
                stackStr.push(s.substring(i , k+1));
                stack.push( new NestedInteger(Integer.parseInt(s.substring(i  ,k + 1))));
                i = k+1;
            }else if(s.charAt(i) == ']'){
                NestedInteger node = new NestedInteger();
                List<NestedInteger> list = new LinkedList<>();
                while (!stackStr.peek().equals("[")){
                    list.add(stack.pop());
                    stackStr.pop();
                }
                for(int kk = list.size() - 1 ; kk >=0 ;kk--)
                    node.add(list.get(kk));
                stackStr.pop();
                stack.add(node);

                stackStr.push("-1");
                i++;
            }else{
                i++;
            }
        }
        return stack.peek();
    }
}
class NestedInteger   {

    public NestedInteger( ) {

    }
    public NestedInteger(int parseInt) {

    }

    public void NestedInteger() {

    }

    public void NestedInteger(int value) {

    }

    public boolean isInteger() {
        return false;
    }

    public Integer getInteger() {
        return null;
    }

    public void setInteger(int value) {

    }

    public void add(NestedInteger ni) {

    }

    public List<NestedInteger> getList() {
        return null;
    }
}