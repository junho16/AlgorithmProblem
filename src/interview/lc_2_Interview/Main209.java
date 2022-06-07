package interview.lc_2_Interview;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * @author Junho
 * @date 2022/5/23 17:43
 */
public class Main209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(15 , new int[]{1,2,3,4,5}));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0 ,r = 1;
        int sum = nums[0] ;
        int res = sum >= target ? 1 : Integer.MAX_VALUE;
        while (l <= r && r <= nums.length){
            if(r < nums.length)
                sum += nums[r];
            if(sum < target){
                r++;
            }else{
                r++;
                res = Math.min(res , r - l  );
                while (sum - nums[l] >= target){
                    sum -= nums[l++];
                    res = Math.min(res , r - l   );
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0:res;
    }
}
