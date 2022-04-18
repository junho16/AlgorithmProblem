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
//    下面是传统dp做法
//    public int rob(int[] nums) {
//        if(nums.length == 1)
//            return nums[0];
//        List<Integer> f = new ArrayList<>();
//        List<Integer> g = new ArrayList<>();
//        f.add(nums[0]);
//        g.add(0);
//        int res = 0;
//        for(int i = 1 ; i < nums.length; i++){
//            int selI = g.get(i-1) + nums[i];
//            f.add(selI);
//            int notSelI = Math.max(f.get(i - 1) , g.get(i - 1));
//            g.add(notSelI);
//            res = Math.max(selI , notSelI);
//        }
//        return res;
//    }

//ok其他dp方法的我也想不出 就再写一遍dp吧
    public static int rob(int[] nums) {
        /**
            dp_x[i]表示第 i 件选的（从前 i 件中选）的最大值
            dp_y[i]表示第 i 件不选（从前 i 件中选）的最大值
            所以可以得到
                若第 i 件选：dp_x[i]=dp_y[i-1] + v[i];
                若第 i 件不选：dp_y[i]=dp_x[i-1] || dp_y[i - 1];
         假设 最后一家到了 ，则第一家是会影响
         最后一家的计算：如果拿了 则是：第一家和倒数第二家不拿的基础上
        */
        int[] dp_x = new int[nums.length + 1];
        int[] dp_y = new int[nums.length + 1];
        dp_x[1] = nums[0];
        dp_y[1] = 0;
        for(int i = 2 ; i <= nums.length ; i++){
            dp_x[i] = dp_y[i - 1] + nums[i - 1];
            dp_y[i] = Math.max(dp_x[i - 1] , dp_y[i - 1]);
        }
        return Math.max(dp_x[nums.length], dp_y[nums.length]);

    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
}
