package offer;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * @author Junho
 * @date 2022/4/12 21:15
 */
public class Main42 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(
                new int[]{
                    -2,1,-3,4,-1,2,1,-5,4
                }
        ));
        System.out.println(maxSubArray(
                new int[]{
                        -2,-1
                }
        ));
    }
    public static  int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i = 0 , last = 0 ; i < nums.length ;i++){
            if(nums[i] >= 0 && last < 0)
                last = nums[i];
            else
                last += nums[i];
            if(last < 0 )
                last = nums[i];
            res = Math.max(res , last);
        }
        return res;
    }
}
