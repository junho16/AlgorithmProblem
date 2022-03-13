package weekGame.week_3_13;

import java.util.*;

/**
 * 6031. 找出数组中的所有 K 近邻下标
 * 给你一个下标从 0 开始的整数数组 nums 和两个整数 key 和 k 。K 近邻下标 是 nums 中的一个下标 i ，并满足至少存在一个下标 j 使得 |i - j| <= k 且 nums[j] == key 。
 *
 * 以列表形式返回按 递增顺序 排序的所有 K 近邻下标。
 */
public class Main6031 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new HashSet();
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == key){
                for(int j = i - k ; j <= i + k ; j++ ){
                    if(j >= 0 && j < nums.length)
                        set.add(j);
                }
            }
        }
        for(Integer i : set){
            res.add(i);
        }
        Collections.sort(res);
        return res;
    }
}