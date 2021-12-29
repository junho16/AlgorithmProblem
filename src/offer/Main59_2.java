package offer;

import javax.management.QueryEval;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 单调队列--可以说是模板题了吧
 *
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */
public class Main59_2 {


    Queue<Integer> mainQueue ;
    Deque<Integer> maxQueue ;

    public Main59_2() {
        mainQueue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if(maxQueue.isEmpty())
            return -1;
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        mainQueue.add(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value ){
            //此处要注意，一定是从后面删除
            maxQueue.pollLast();
        }
        // if(maxQueue.isEmpty() || value >= maxQueue.peekLast())
        maxQueue.addLast(value);
    }

    public int pop_front() {
        if(mainQueue.isEmpty())
            return -1;
        int x = mainQueue.poll();
        if(!maxQueue.isEmpty() && maxQueue.peekFirst() == x)
            maxQueue.pollFirst();
        return x;
    }
}
