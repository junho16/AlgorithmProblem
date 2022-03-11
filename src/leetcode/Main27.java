package leetcode;


/**
 * 双指针做法 类似于emm快排的一个思路
 *
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Main27 {
//    3223 3
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            while(r > 0 && nums[r] == val){
                r--;
            }
            while (l < nums.length && nums[l] != val){
                l++;
            }
            if(l < r){
                // System.out.println(l+" "+r);
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
            }
        }
        for(int i =0 ; i < nums.length ;i++){
            System.out.print(nums[i]+" ");
        }
        for(int i = nums.length - 1  ; i >= 0 ; i--){
            if(nums[i] != val){
                return i+1;
            }
        }
        return 0;

    }
}
