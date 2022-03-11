package lc_2_Interview;

import java.util.Arrays;
import java.util.Stack;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class Main121 {
    public int maxProfit(int[] pp) {
        Stack<Integer> stack = new Stack<>();
        int res = Integer.MIN_VALUE;
        int[] prices = new int[pp.length + 1];
        prices = Arrays.copyOf(pp, pp.length+1);
        prices[prices.length - 1] = 0;
        int stackLast = 0;
        for(int i = 0 ; i < prices.length ; i++ ){
            while (!stack.isEmpty() && prices[i] < stack.peek()){
                res = Math.max(res , stack.peek() - stackLast);
                stack.pop();
            }
            if(stack.isEmpty()){
                stackLast = prices[i];
                stack.add(prices[i]);
            }else{
                stack.add(prices[i]);
            }
        }
        return res;
    }

//    下面没有优化取栈底元素 直接超时 上面可以过但是 5 %
//    public int maxProfit(int[] pp) {
//        Stack<Integer> stack = new Stack<>();
//        int res = Integer.MIN_VALUE;
//        int[] prices = new int[pp.length + 1];
//        prices = Arrays.copyOf(pp, pp.length+1);
//        prices[prices.length - 1] = 0;
//        for(int i = 0 ; i < prices.length ; i++ ){
//            while (!stack.isEmpty() && prices[i] < stack.peek()){
//                res = Math.max(res , stack.peek() - getLast(stack));
//                stack.pop();
//            }
//            stack.add(prices[i]);
//        }
//        return res;
//    }
//    public int getLast(Stack<Integer> stack){
//        Stack<Integer> tmp = new Stack();
//        int x = 0;
//        while (!stack.isEmpty()){
//            x = stack.pop();
//            tmp.push(x);
//        }
//        while (!tmp.isEmpty()){
//            stack.push(tmp.pop());
//        }
//        return x;
//    }
}
