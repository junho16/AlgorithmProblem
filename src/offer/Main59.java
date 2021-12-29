package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Main59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int index = 0 ;
        Deque<Integer> deque = new LinkedList();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0 ;i < nums.length ;i++){
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(i >= k -1 ){
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
