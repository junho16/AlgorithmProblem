package leetcode;

/**
 * 1470. 重新排列数组
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * @author Junho
 * @date 2022/9/19 11:49
 */
public class Main1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0 ; i < n ; i++)
            left[i] = nums[i];
        for(int i = n , idx = 0 ; i < 2 * n ; i++)
            right[idx++] = nums[i];
        int[] res = new int[2 * n];
        for(int i = 0 , idx = 0 ; i < n ; i++){
            int n1 = left[i];
            int n2 = right[i];
            res[idx++] = n1;
            res[idx++] = n2;
        }
        return res;
    }
}
