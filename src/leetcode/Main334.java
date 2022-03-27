package leetcode;

/**
 * 334. 递增的三元子序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * @author Junho
 * @date 2022/3/26 9:16
 */
public class Main334 {

    /**
     * 贪心--不断比较 min 和 mid
     * @param nums
     * @return
     */
     public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ;i++){
            if(nums[i] > mid){
                System.out.print(min+" " + mid+" " + nums[i]);
                return true;
            }
            else if(nums[i] < min){
                min = nums[i];
            }
            else if(nums[i] > min && nums[i] < mid){
                mid = nums[i];
            }
        }
        System.out.print(min+" " + mid+" "  );
        return false;
    }
}
