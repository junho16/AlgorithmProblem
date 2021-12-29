package max;

import java.util.Stack;

/**
 * 单调栈经典问题
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
public class Main42 {
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i < height.length ; i++){
            //在这里是用了一个小聪明（技巧），因为第一次算面积的时候会因为前一个柱子与栈顶之间没有缝隙（i - stack.peek() -1）的值是0
            //然后直接下一次循环 循环之前已经更新了last的值是当前栈顶（last在图上看是从后往前的）
            int last = 0;
            while (!stack.isEmpty() && height[i] > height[stack.peek()] ){
                res += (
                        (height[stack.peek()] - last) * (i - stack.peek() -1)
                );
                last = height[stack.peek()];
                stack.pop();
            }
            //这里不要忘记需要再算一下 假设最后遇到了比自己高的 需要加上当前柱子和比自己高的柱子之间的面积
            if(!stack.isEmpty()){
                res += (
                        (height[i] - last) * (i - stack.peek() -1)
                );
            }
            stack.push(i);
        }
        return res;
    }
}
