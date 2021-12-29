package leetcode;

import java.util.Stack;

/**
 * 单调栈
 * 739. 每日温度
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class Main739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = temperatures.length -1 ; i >=0 ; i--){
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        for(int i = 0 ;i < res.length ; i++){
            System.out.print(res[i] + " ");
        }
        return res;
    }
}
