package leetcode;

/**
 * 396. 旋转函数
 * 给定一个长度为 n 的整数数组 nums 。
 *
 * 假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：
 *
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * 返回 F(0), F(1), ..., F(n-1)中的最大值 。
 *
 * 生成的测试用例让答案符合 32 位 整数。
 * @author Junho
 * @date 2022/4/22 9:34
 */
public class Main396 {

    /**
     * F(0) = 0 * nums[0] + 1 * nums[1] + ... + (n−1) * nums[n−1]
     * F(1) = 1 * nums[0] + 2 * nums[1] + ... + (0) * nums[n-1]
     * 也就是说：F[i] = F[i-1] + sum - n * nums[i - 1]
     */
    public int maxRotateFunction(int[] nums) {
        int[] f = new int[nums.length];
        int numsSum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            numsSum += nums[i];
            f[0] += (i * nums[i]);
        }
        int res = f[0];
        for(int i = 1 ; i < f.length ; i++){
            f[i] = f[i-1] + numsSum - (nums.length) * nums[nums.length - i];
            res = Math.max(res , f[i]);
        }
        return res;
    }

}
