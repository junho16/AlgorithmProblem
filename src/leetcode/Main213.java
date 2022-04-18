package leetcode;

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * @author Junho
 * @date 2022/4/16 16:24
 */
public class Main213 {
    public static int rob(int[] nums) {
        if(nums.length <= 2){
            int res = 0;
            for(int i = 0 ; i < nums.length ;i++){
                res = Math.max(res  , nums[i]);
            }
            return res;
        }
        //第一遍dp 求出第一家选的情况下的最大值
        int[] dp_x = new int[nums.length + 1];
        int[] dp_y = new int[nums.length + 1];
        dp_x[2] = nums[2];
        dp_y[2] = 0;
        for(int i = 3 ; i < nums.length - 1 ; i++){
            //选择第i家
            dp_x[i] = dp_y[i - 1] + nums[i];

            //不选第i家
            dp_y[i] = Math.max(dp_x[i - 1] , dp_y[i - 1]);
        }
        int res_1 = Math.max(dp_x[nums.length - 2] , dp_y[nums.length - 2]);
        res_1 += nums[0];

        //第二遍dp 求出第一家不选的情况下的最大值
        dp_x = new int[nums.length + 1];
        dp_y = new int[nums.length + 1];
        dp_x[1] = nums[1];
        dp_y[1] = 0;
        for(int i = 2 ; i < nums.length ; i++){
            //选择第i家
            dp_x[i] = dp_y[i - 1] + nums[i];

            //不选第i家
            dp_y[i] = Math.max(dp_x[i - 1] , dp_y[i - 1]);
        }
        int res_2 = Math.max(dp_x[nums.length - 1] , dp_y[nums.length - 1]);

        return Math.max(res_1  ,res_2);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{ 1, 2,3 }));
    }
}
