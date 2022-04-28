package leetcode;

/**
 * 674. 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 *
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列
 *
 * @author Junho
 * @date 2022/4/21 15:40
 */
public class Main674 {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        for(int tmp = 1 , i = 1 ; i < nums.length ; i++ ){
            if(nums[i-1] < nums[i]){
                tmp++;
                res = Math.max(res ,tmp);
            }else{
                tmp = 1;
            }
        }
        return res;
    }
}
