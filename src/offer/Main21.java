package offer;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 */
public class Main21 {
    public int[] exchange(int[] nums) {
        int l = -1;
        int r = nums.length;
        while (l < r){
            while (nums[l] % 2 == 0)
                ++l;
            while (nums[r] % 2 == 0)
                --r;
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
        }
        return nums;
    }
}
