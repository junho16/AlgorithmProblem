package offer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class Main53 {
    public int missingNumber(int[] nums) {

        if(nums.length==1){
            if(nums[0] == 0 )
                return 1;
            else
                return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int mid = (l + r ) >> 1;
            if(nums[mid] == mid){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return nums[l] == l?l+1:l;
    }
}
