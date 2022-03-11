package lc_2_Interview;

import java.util.Stack;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Main42 {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0 ; i < height.length ; i++){
            int last = 0 ;
            while (!stack.isEmpty() && height[i] > height[stack.peek()] ){
                res += (
                        (height[stack.peek()] - last) * (i - stack.peek() - 1)
                );
                last = height[stack.peek()];
                stack.pop();
            }
            if(!stack.isEmpty()){
                res += (
                        (height[i] - last) * (i - stack.peek() - 1)
                );
            }
            stack.push(i);
        }
        return res;
    }
}
