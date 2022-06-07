package interview.lc_2_Interview;

import java.util.Stack;

/**
 * 单调栈 模板题
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，
 * 返回一个数组 answer ，
 * 其中 answer[i] 是指在第 i 天之后，才会有更高的温度。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class Main739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = temperatures.length - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = 0;
            }else{
                res[i] = stack.peek() - i ;
            }
            stack.add(i);
        }
        return res;
    }
}
