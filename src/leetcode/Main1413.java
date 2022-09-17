package leetcode;

/**
 * 1413. 逐步求和得到正数的最小值
 * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
 *
 * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
 *
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
 *
 * @author Junho
 * @date 2022/8/13 18:30
 */
public class Main1413 {
    public int minStartValue(int[] nums) {
        int min = 0;
        for(int i = 0, sum = 0 ; i < nums.length ;i++){
            sum += nums[i];
            min = Math.min(sum , min);
        }
        return min * -1 + 1;
    }
}
