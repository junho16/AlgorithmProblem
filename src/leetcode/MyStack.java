package leetcode;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * @author Junho
 * @date 2022/3/23 14:10
 */
public class MyStack {

    //主队列
    Queue<Integer> queue_1;

    //存放栈顶元素
    Queue<Integer> queue_2;

    public MyStack() {
        queue_1 = new LinkedList<>();
        queue_2 = new LinkedList<>();
    }

    public void push(int x) {
        queue_1.add(x);
        if(queue_2.isEmpty())
            queue_2.add(x);
        else{
            queue_2.poll();
            queue_2.add(x);
        }
    }

    public int pop() {
        while (queue_1.peek() != queue_2.peek()){
            int x = queue_1.poll();
            if(queue_1.peek() == queue_2.peek()){
                queue_2.poll();
                queue_2.add(x);
                int res =  queue_1.poll();
                queue_1.add(x);
                return res;
            }else{
                queue_1.add(x);
            }
        }
        if(queue_1.peek() == queue_2.peek()){
            queue_1.poll();
            return queue_2.poll();
        }
        return -1;
    }

    public int top() {
        return queue_2.peek();
    }

    public boolean empty() {
        return queue_1.isEmpty() && queue_2.isEmpty();
    }
}