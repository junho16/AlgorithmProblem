package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1995. 统计特殊四元组
 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 *
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 */
public class Main1995 {
    public int countQuadruplets(int[] nums) {
        Set<Integer> hashset = new HashSet();
        int res = 0 ;
        for(int i = 0 ;i < nums.length ; i++)
            for(int j = 0 ; j < nums.length ; j++)
                hashset.add(nums[i] - nums[j]);
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 0 ; j < nums.length ; j++ ){
                if(hashset.contains(nums[i] + nums[j]))
                    res++;
            }
        }
        return res;
    }
}
