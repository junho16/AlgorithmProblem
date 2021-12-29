package offer;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public  class Main30 {
    public Stack<Integer> numStack;
    public Stack<Integer> minStack;
    /** initialize your data structure here. */
    public Main30() {
        numStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        numStack.add(x);
        if(minStack.isEmpty()){
            minStack.add(x);
        }else{
            if(x >= minStack.peek()){
                minStack.add(minStack.peek());
            }else{
                minStack.add(x);
            }
        }
    }

    public void pop() {
        numStack.pop();
        minStack.pop();
    }

    public int top() {
        return numStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
