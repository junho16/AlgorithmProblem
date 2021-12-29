package leetcode;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 解法：摩尔投票
 */
public class Main169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int lastNum = -1;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0){
                lastNum = nums[i];
                count++;
                continue;
            }
            if(nums[i] == lastNum)
                count ++;
            else
                count--;
        }
        return lastNum;
    }
}
