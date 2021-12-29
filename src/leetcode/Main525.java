package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */
public class Main525 {
    public int findMaxLength(int[] nums) {
        //存储差值和下标
        Map<Integer, Integer> map = new HashMap();
        map.put(0,0);
        int res = 0;
        for (int i = 1, one = 0 , zero = 0 ; i <= nums.length ; i++){
            if(nums[i-1] == 0) zero++;
            else one++;
            int k = one - zero;
            if(map.containsKey(k)){
                res = Math.max(res , i - map.get(k));
            }else{
                map.put(k , i);
            }
        }
        return res;
//        int[] prefixSum = new int[nums.length];
//        prefixSum[0] = nums[0];
//        for(int i = 1 ; i < nums.length ;i++ ){
//            prefixSum[i] = nums[i]+prefixSum[i-1];
//        }
//        int res = Integer.MIN_VALUE;
//        for(int i = 0 , j = 0; i < nums.length ; i++){
//            while (j < i && nums[i] - nums[j] != 2*(i-j+1)){
//                j++;
//            }
//            if(nums[i] - nums[j] == 2*(i-j+1)){
//                res = Math.max(res , i-j+1);
//            }
//        }
//        return res;
    }
}
