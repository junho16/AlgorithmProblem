package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class Main198 {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        List<Integer> f = new ArrayList<>();
        List<Integer> g = new ArrayList<>();
        f.add(nums[0]);
        g.add(0);
        int res = 0;
        for(int i = 1 ; i < nums.length; i++){
            int selI = g.get(i-1) + nums[i];
            f.add(selI);
            int notSelI = Math.max(f.get(i - 1) , g.get(i - 1));
            g.add(notSelI);
            res = Math.max(selI , notSelI);
        }
        return res;
    }
}
