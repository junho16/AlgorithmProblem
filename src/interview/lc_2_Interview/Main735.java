package interview.lc_2_Interview;

import java.util.Arrays;
import java.util.Stack;

/**
 * 735. 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 *
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 */
public class Main735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < asteroids.length ; i++){
            if(asteroids[i] > 0)
                stack.push(asteroids[i]);
            else{
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < asteroids[i] * -1 )
                    stack.pop();
                if(!stack.isEmpty() && stack.peek() > 0 && stack.peek() == -1 * asteroids[i]){
                    stack.pop();
                    continue;
                } else if(stack.isEmpty() || stack.peek() < 0 ){
                    stack.push(asteroids[i]) ;
                    continue;
                } else if(!stack.isEmpty() && stack.peek() > 0 && stack.peek() > -1 * asteroids[i]){
                    continue;
                }
            }
        }
        // for(Integer i : stack){
        //     System.out.print(i + " ");
        // }
        int[] res = new int[asteroids.length];
        int index = 0;
        for(Integer i : stack){
            res[index++] = i;
        }
        return Arrays.copyOf(res , index);
    }
}
