package offer;

import java.util.Stack;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class Main31 {
//    按照入栈序列的顺序压栈
//    每次压栈之后，循环判断 “栈顶元素 = 弹出序列的当前元素” 是否成立，将符合弹出序列顺序的栈顶元素全部弹出
//    最后如果栈为空则满足条件，否则不满足
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> numStack = new Stack();
        int idx = 0;
        for(int i = 0; i < pushed.length ; i++){
            numStack.push(pushed[i]);
            while(idx < popped.length && !numStack.isEmpty() && popped[idx] == numStack.peek()){
                idx++;
                numStack.pop();
            }
        }
        return numStack.isEmpty();
    }

}
