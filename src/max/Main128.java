package max;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Main128 {
    public static void main(String[] args) {
        System.out.println(new Main128().longestConsecutive(null));
    }
    public int longestConsecutive(int[] n) {
        int[] nums = { 100,4,200,1,3,2 };
        if(nums.length == 0)
            return 0;
        Set<Integer> hashset = new HashSet();

        int res = 1;
        for(int i = 0 ;i < nums.length ;i++){
            hashset.add(nums[i]);
        }
        for(int i = 0 ; i < nums.length ;i++){
            if( hashset.contains(nums[i]) && !hashset.contains(nums[i]-1)){
                int j = nums[i];
                hashset.remove(j);
                int len = 1;
                while (hashset.contains(j+1)){
                    len++;
                    j++;
                    hashset.remove(j);
                }
                res = Math.max(res , len);
            }
        }
        return res;
    }
}
