package offer;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class Main57 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int s = nums[l] + nums[r];
            if(s == target){
                res[0] = nums[l];
                res[1] = nums[r];
                return res;
            }else if(s < target){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}