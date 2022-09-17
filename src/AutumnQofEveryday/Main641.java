package AutumnQofEveryday;

/**
 * 641. 设计循环双端队列
 * 设计实现双端队列。
 *
 * 实现 MyCircularDeque 类:
 *
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 * @author Junho
 * @date 2022/9/12 16:50
 */
public class Main641 {

//    public MyCircularDeque(int k) {
//
//    }

    int capacity;

    int frontIdx , endIdx;

    int[] data;

    public Main641(int k) {
        // k+1 的原因是判断其是否为空或者其他一些操作时 endIdx应该+1再处理 即：在满状态的情况下，endIdx下一个位置应该为空
        // 其实是k+1是因为要保证队列可以有 存 0-k个元素 即k+1种状态
        data = new int[k + 1];
        capacity = k + 1;
        frontIdx = endIdx = 0;
    }

    public boolean insertFront(int value) {
        if(isFull())
            return false;
        frontIdx = (frontIdx - 1 + capacity) % capacity;
        data[frontIdx] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull())
            return false;
        data[endIdx] = value;
        endIdx = (endIdx + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty())
            return false;
        frontIdx = (frontIdx + 1 + capacity) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty())
            return false;
        endIdx = (endIdx - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if(isEmpty())
            return -1;
        return data[frontIdx];
    }

    public int getRear() {
        if(isEmpty())
            return -1;
        return data[(endIdx-1+capacity)%capacity];
    }

    public boolean isEmpty() {
        return  frontIdx == endIdx;
    }

    public boolean isFull() {
        return frontIdx == (endIdx + 1) % capacity;
    }
}
