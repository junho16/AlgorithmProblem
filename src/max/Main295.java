package max;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
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
 * 示例：
 */
public class Main295 {
    public PriorityQueue<Integer> bigNumQueue;
    public PriorityQueue<Integer> smallNumQueue;
    public int count;
    public Main295() {
        count = 0;
        //java的堆默认是最小堆
        //大根堆
        bigNumQueue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        smallNumQueue = new PriorityQueue();
    }

    public void addNum(int num) {
        count++;
        bigNumQueue.add(num);
        while(!bigNumQueue.isEmpty() && !smallNumQueue.isEmpty() && bigNumQueue.peek() > smallNumQueue.peek()){
            int num_1 = smallNumQueue.poll();
            int num_2 = bigNumQueue.poll();
            smallNumQueue.add(num_2);
            bigNumQueue.add(num_1);
        }
        if(bigNumQueue.size() - smallNumQueue.size() > 1){
            smallNumQueue.add(bigNumQueue.poll());
        }
    }
    public double findMedian() {
        if((count % 2) == 1 ){
            return bigNumQueue.peek();
        }else{
            Integer num_1 = bigNumQueue.peek();
            Integer num_2 = smallNumQueue.peek();
            return (double)( num_1+num_2 )/2;
        }
//        System.out.println("========================");
//        for(Integer I : bigNumQueue){
//            System.out.print(I+" ");
//        }
//        System.out.println();
//        for(Integer I : smallNumQueue){
//            System.out.print(I+" ");
//        }
//        System.out.println();
//        System.out.println("========================");


    }
}
