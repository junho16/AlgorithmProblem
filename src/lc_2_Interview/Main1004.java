package lc_2_Interview;

/**
 * 算是一个双指针 --》将其转化为：求出一个最长的区间内的0的个数不超过k
 *
 * 1004. 最大连续1的个数 III
 * 给定一个二进制数组 nums 和一个整数 k ，如果可以翻转最多k 个 0 ，则返回 数组中连续 1 的最大个数 。
 */
public class Main1004 {
    public int longestOnes(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        for(int i = 0 , j = 0 , cnt = 0 ; i < nums.length ; i++ ){
            if(nums[i] == 0)
                cnt++;
            while (cnt > k){
                if(nums[j] == 0){
                    cnt--;
                }
                j++;
            }
            res = Math.max(res , i - j + 1);
        }
        return res;
    }
}
