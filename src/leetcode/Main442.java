package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 原地hash算法 其实也不算完全体的原地hash 但是大差不差 因为思路差不多
 * 为了防止数组越界 需要将 nums[i] 求绝对值后 - 1 根据此来判断其位置上的值是否为负
 * 如果为负则说明已经出现过了， 则可以加入返回值list
 * 如果为正 则将其 * -1 以为了下次遍历到这个数可以看出其已经出现过（利用了 ： 1 ≤ a[i] ≤ n ）
 *
 * 442. 数组中重复的数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 */
public class Main442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ;i < nums.length ; i++){
            int k = Math.abs(nums[i]);
            if(nums[k - 1] < 0)
                res.add(Math.abs(nums[i]));
            else{
                nums[k - 1] *= -1;
            }
        }
        return res;
    }
}
