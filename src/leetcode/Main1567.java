package leetcode;

/**
 * 1567. 乘积为正数的最长子数组长度
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 *
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 *
 * 请你返回乘积为正数的最长子数组长度。
 *
 * @author Junho
 * @date 2022/4/22 22:34
 */
public class Main1567 {
    public int getMaxLen(int[] nums) {
        /**
         * f[i] 表示在i位置之前的正数的最大长度
         * g[i] 表示在i位置之前的负数的最大长度
         */
        int[] f = new int[nums.length ];
        int[] g = new int[nums.length ];
        f[0] = nums[0] > 0 ? 1 : 0;
        g[0] = nums[0] < 0 ? 1 : 0;
        int res = f[0] ;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] > 0){
                //正数
                f[i] = f[i - 1] + 1;
                g[i] = g[i - 1] > 0 ? g[i - 1] + 1 : 0;
                // g[i] = g[i - 1] + 1;
            }else if(nums[i] < 0){
                //负数的话会改变符号
                f[i] = g[i - 1] > 0 ? g[i - 1] + 1 : 0;
                g[i] = f[i - 1] > 0 ? f[i  -1] + 1 : 1;
            }else{
                f[i] = 0;
                g[i] = 0;
            }
            res = Math.max(f[i] , res);
        }
        return res;
    }
}
