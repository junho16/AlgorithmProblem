package leetcode;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度
 *
 * @author Junho
 * @date 2022/4/21 19:23
 */
public class Main718 {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length +1 ][nums2.length + 1];
        int res = 0;
        for(int i = 1; i <= nums1.length ; i++){
            for(int j = 1 ; j <= nums2.length ; j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = 0;
                }
                res = Math.max(res , dp[i][j]);
            }
        }
        return res;
    }
}
