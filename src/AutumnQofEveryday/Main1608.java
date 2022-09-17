package AutumnQofEveryday;

import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 * 注意： x 不必 是 nums 的中的元素。
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
 * @author Junho
 * @date 2022/9/16 22:26
 */
public class Main1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int left = 0 , right = nums.length;
        while (left < right){
            int mid = (left + right + 1) >> 1;
            int cnt = 0;
            for(int i = 0 ;i < nums.length ; i++){
                if(nums[i] >= mid)
                    cnt++;
            }
            if(cnt < mid){
                right = mid - 1;
            }else{
                if(cnt == mid)
                    return mid;
                left = mid;
            }
        }
        return -1;
    }
}
