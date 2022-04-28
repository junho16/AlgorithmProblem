package leetcode;

/**
 * 905. 按奇偶排序数组
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 *
 * 返回满足此条件的 任一数组 作为答案。
 *
 * @author Junho
 * @date 2022/4/28 10:43
 */
public class Main905 {
    public int[] sortArrayByParity(int[] nums) {
        int idx_s = 0;
        int idx_e = nums.length - 1;
        while (idx_s < idx_e  ){
            while (idx_s < nums.length && nums[idx_s] % 2 == 0)
                idx_s++;
            while (idx_e >= 0 && nums[idx_e] % 2 == 1)
                idx_e--;
            if(idx_s < idx_e){
                int tmp = nums[idx_e];
                nums[idx_e--] = nums[idx_s];
                nums[idx_s++] = tmp;
            }
        }
        return nums;
    }
}
