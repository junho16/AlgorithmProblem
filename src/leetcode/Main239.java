package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 本题是单调队列，还记得单调栈么？接雨水的那个题
 * 本题中单调队列需要使用到双端队列
 * 队列的前在不断删除 后端在不断添加目前的最大值
 *
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 */
public class Main239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1 ];
        int idx = 0;
        Deque<Integer> deque = new LinkedList();
        for(int i = 0 ;i < nums.length ;i++){

            //此处的 frontNum < i - k + 1 需要特别注意
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1 )
                deque.pollFirst();
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
            System.out.println(deque.size());
            if(i >= k-1)
                res[idx++] = nums[deque.peekFirst()];
        }
        return res;
    }
}
