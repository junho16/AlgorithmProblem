package offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 */
public class Main41 {
    PriorityQueue<Integer> bigQueue;
    PriorityQueue<Integer> smallQueue;
    int count ;
    /** initialize your data structure here. */
    public Main41() {
        count = 0;
        bigQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        smallQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count++;
        bigQueue.add(num);
        if (!smallQueue.isEmpty() && !bigQueue.isEmpty() && smallQueue.peek() < bigQueue.peek()){
            int num1 = smallQueue.poll();
            int num2 = bigQueue.poll();
            smallQueue.add(num2);
            bigQueue.add(num1);
        }
        if(bigQueue.size() - smallQueue.size() > 1 ){
            smallQueue.add(bigQueue.poll());
        }
    }

    public double findMedian() {
        for(Integer i : smallQueue){
            System.out.print (i+" ");
        }
        System.out.print  ( "==");
        for(Integer i : bigQueue){
            System.out.print (i+" ");
        }
        System.out.println ( );
        System.out.println ( smallQueue.size() + bigQueue.size() );
        System.out.println ( );

        if((count) % 2 == 1 ){
            return bigQueue.peek();
        }else{
            Integer num1 = bigQueue.peek();
            Integer num2 = smallQueue.peek();
            System.out.println ((num1+num2)+"-->"+ (( double)num1+num2)/2);
            return  ((double)(num1+num2)/ 2);

        }
    }
}
