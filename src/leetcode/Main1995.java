package leetcode;

import sun.applet.Main;

import java.util.HashSet;
import java.util.Set;

/**
 * 1995. 统计特殊四元组
 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 *
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 */
public class Main1995 {
    public int countQuadruplets(int[] nums) {
        int res = 0;
        int[] cnt = new int[10010];
        for (int b = nums.length - 3; b >= 0; b--) {
            //这里加一个偏移量是因为两个数相减可能是一个负数，为了防止数据越界 所以使用一个偏移量 其实200 就够了 因为数据的范围是0-100
            for (int d = b + 2; d < nums.length; d++)
                cnt[nums[d] - nums[b + 1] + 1000]++;
            for (int a = 0; a < b; a++)
                res += cnt[nums[a] + nums[b] + 1000];
        }
        return res;
    }

    public static void main(String[] args) {
        Main1995 main = new Main1995();
        System.out.println(main.countQuadruplets(new int[]{1,2,3,6}));
    }


}
