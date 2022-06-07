package interview.lc_2_Interview;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 也就是队列前端一直维护最大值（有越界情况则进行删除），新加入的元素从队尾进入，
 * 如果出现比前面的元素大的情况，则删除前面比其小的元素并入队
 *
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * @author Junho
 * @date 2022/5/27 15:48
 */
public class Main239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //双端队列中存的一直是下标
        Deque<Integer> deque = new LinkedList();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(!deque.isEmpty() && i - deque.peekFirst() >= k){
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(i >= k - 1)
                res[index++] = nums[deque.peekFirst()];
        }
        return res;
//        优先队列过不全数据 会存在超时的情况，还是应该用单调队列（和双端队列）做，
//        也就是队列前端一直维护最大值（有越界情况则进行删除），新加入的元素从队尾进入，如果出现比前面的元素大的情况，则删除前面比其小的元素并入队
//        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        int[] res = new int[nums.length - k];
//        int index = 0;
//        for(int i = 0; i < nums.length ; i++){
//            if(i < k){
//                queue.add(nums[i]);
//                if(i == k - 1){
//                    res[index++] = queue.peek();
//                }
//                continue;
//            }
//            queue.remove(nums[i-k]);
//            queue.add(nums[i]);
//            res[index++] = queue.peek();
//        }
//        return res;
    }
}
