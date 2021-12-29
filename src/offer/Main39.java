package offer;

/**
 * 类似于完美括号匹配的一个题目 使用标记位++--最后得到结果
 *
 剑指 Offer 39. 数组中出现次数超过一半的数字
 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Main39 {
    public int findRepeatNumber(int[] nums) {
        int last = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length ;i++ ){
            if(nums[i] != last){
                if(--count == 0){
                    last = nums[i];
                    count = 1;
                }
            }else{
                count++;
            }
        }
        return last;
    }
}
