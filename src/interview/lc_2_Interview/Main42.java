package interview.lc_2_Interview;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 笑死，单刷接雨水很难吗？
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Main42 {
    public static void main(String[] args) {
        trap(new int[]{ 0,1,0,2,1,0,1,3,2,1,2,1});
    }
    public static int trap(int[] height) {
        Set<String> set = new HashSet<>();
        Stack<Integer> stack = new Stack();
        int[] stackMap_1 = new int[height.length];
        int[] stackMap_2 = new int[height.length];
        //左边比其大的
        for(int i = 0 ; i < height.length ; i++){
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]){
                stack.pop();
            }
            stackMap_1[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }

        //    for(Integer i : stackMap_1){
        //        System.out.print(i + " ");
        //    }
        //    System.out.println();

        stack = new Stack<>();
        //右边比其大的
        for(int i = height.length - 1 ; i >= 0 ; i--){
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]){
                stack.pop();
            }
            stackMap_2[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        //    for(Integer i : stackMap_2){
        //        System.out.print(i + " ");
        //    }
        //    System.out.println();


        int res = 0;
        for(int i = 0 ;i < height.length; i++){
            if(stackMap_1[i] != -1 && stackMap_2[i] != -1){
                if(!set.contains( stackMap_1[i]  +" "+
                        stackMap_2[i] + " " +
                        height[i] +" " +
                        (Math.min(height[stackMap_1[i]] , height[stackMap_2[i]]) - height[i]))){
                    set.add(stackMap_1[i]  +" "+
                            stackMap_2[i] + " " +
                            height[i] +" " +
                            (Math.min(height[stackMap_1[i]] , height[stackMap_2[i]]) - height[i]));

                    res += (
                            (Math.min(height[stackMap_1[i]] , height[stackMap_2[i]])  - height[i])
                                    * (stackMap_2[i] - stackMap_1[i] -1 )
                    );
                }
            }
        }
        return res;
    }


//    public int trap(int[] height) {
//        Stack<Integer> stack = new Stack<>();
//        int res = 0;
//        for(int i = 0 ; i < height.length ; i++){
//            int last = 0 ;
//            while (!stack.isEmpty() && height[i] > height[stack.peek()] ){
//                res += (
//                        (height[stack.peek()] - last) * (i - stack.peek() - 1)
//                );
//                last = height[stack.peek()];
//                stack.pop();
//            }
//            if(!stack.isEmpty()){
//                res += (
//                        (height[i] - last) * (i - stack.peek() - 1)
//                );
//            }
//            stack.push(i);
//        }
//        return res;
//    }
}
