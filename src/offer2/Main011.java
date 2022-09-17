package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * @author Junho
 * @date 2022/7/9 15:00
 */
public class Main011 {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1 ,0 }));
    }
    public static int findMaxLength(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 ,-1);
        int res = 0;
        for(int i = 0 , zero = 0 , one = 0 ; i < nums.length ; i++ ){
            if(nums[i] == 1)
                one++;
            else
                zero++;
            if(map.containsKey(one - zero)){
                res = Math.max(res , i - map.get(one - zero));
            }else{
                map.put(one - zero , i);
            }
        }
        return res;
    }
}
