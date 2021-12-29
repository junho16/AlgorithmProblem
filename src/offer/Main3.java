package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class Main3 {
    public int findRepeatNumber(int[] nums) {
        for(int i = 0 ; i < nums.length ;i++  ){
            //注意这里的停止条件， 如果 nums[i]==i 不说了，就停下 ==》那么如果nums[nums[i]] == nums[i]就说明遇到了重复的数
            while (i != nums[i] && nums[nums[i]] != nums[i] ) {
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
            //注意 这里一定是 i!=nums[i] 使用别的判断会出问题
            if (i != nums[i]) {
                return nums[i];
            }
        }
        return -1;

    }
//    public int findRepeatNumber(int[] nums) {
//
//        Set<Integer> set = new HashSet();
//        for(int i = 0 ; i < nums.length ; i++){
//            if(set.contains(nums[i]))
//                return nums[i];
//            else{
//                set.add(nums[i]);
//            }
//        }
//        return 0;
//    }
}
