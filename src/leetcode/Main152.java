package leetcode;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 * @author Junho
 * @date 2022/4/22 17:07
 */
public class Main152 {
    public int maxProduct(int[] nums) {
        /**
         * 维护一个乘积最大值和乘积一个最小值
         * 如果遇到了负数，则交换二者，因为
         */
        int minNum = 1;
        int maxNum = 1;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length ;i++){
            if(nums[i] < 0){
                int tmp = maxNum;
                maxNum = minNum;
                minNum = tmp;
            }
            maxNum = Math.max(maxNum * nums[i] , nums[i]);
            minNum = Math.min(minNum * nums[i] , nums[i]);
            res = Math.max(res , maxNum);
        }
        res = Math.max(res , maxNum);
        return res;
    }
}
/**
 * 下面这个思路也是挺正常的 ==》
 *
 * 解题思路
 * 这题是求数组中子区间的最大乘积，对于乘法，我们需要注意，负数乘以负数，会变成正数，所以解这题的时候我们需要维护两个变量，当前的最大值，以及最小值，最小值可能为负数，但没准下一步乘以一个负数，当前的最大值就变成最小值，而最小值则变成最大值了。
 *
 * 我们的动态方程可能这样：
 *
 * maxDP[i + 1] = max(maxDP[i] * A[i + 1], A[i + 1],minDP[i] * A[i + 1])
 * minDP[i + 1] = min(minDP[i] * A[i + 1], A[i + 1],maxDP[i] * A[i + 1])
 * dp[i + 1] = max(dp[i], maxDP[i + 1])
 *
 * 这里，我们还需要注意元素为0的情况，如果A[i]为0，那么maxDP和minDP都为0，
 * 我们需要从A[i + 1]重新开始。
 *
 * C++
 *
 * class Solution {
 * public:
 *     int maxProduct(vector<int>& nums) {
 *         int n = nums.size();
 *         if(n == 0){
 *             return 0;
 *         } else if(n == 1) {
 *             return nums[0];
 *         }
 *         int p = nums[0];
 *         int maxP = nums[0];
 *         int minP = nums[0];
 *         for(int i = 1; i < n; i++) {
 *             int t = maxP;
 *             maxP = max(max(maxP * nums[i], nums[i]), minP *nums[i]);
 *             minP = min(min(t * nums[i], nums[i]), minP * nums[i]);
 *             p = max(maxP, p);
 *         }
 *         return p;
 *     }
 * };
 *
 * 作者：spicy_onion
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray/solution/dpfang-fa-xiang-jie-by-yang-cong-12/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
