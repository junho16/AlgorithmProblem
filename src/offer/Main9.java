package offer;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class Main9 {
    public Stack<Integer> numStack;
    public Stack<Integer> tmpStack;
    public Main9() {
        numStack = new Stack<>();
        tmpStack = new Stack<>();
    }

    public void appendTail(int value) {
        numStack.add(value);
        if(tmpStack.isEmpty()){
            while (!numStack.isEmpty()){
                tmpStack.add(numStack.pop());
            }
        }
    }

    public int deleteHead() {
        if(tmpStack.isEmpty()){
            while (!numStack.isEmpty()){
                tmpStack.add(numStack.pop());
            }
        }
        if(tmpStack.isEmpty()){
            return -1;
        }else{
            return tmpStack.pop();
        }
    }
}
