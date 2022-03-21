package weekGame.week_3_20;

/**
 * 6027. 统计数组中峰和谷的数量 显示英文描述
 * 通过的用户数51
 * 尝试过的用户数81
 * 用户总通过次数51
 * 用户总提交次数88
 * 题目难度Easy
 * 给你一个下标从 0 开始的整数数组 nums 。如果两侧距 i 最近的不相等邻居的值均小于 nums[i] ，则下标 i 是 nums 中，某个峰的一部分。类似地，如果两侧距 i 最近的不相等邻居的值均大于 nums[i] ，则下标 i 是 nums 中某个谷的一部分。对于相邻下标 i 和 j ，如果 nums[i] == nums[j] ， 则认为这两下标属于 同一个 峰或谷。
 *
 * 注意，要使某个下标所做峰或谷的一部分，那么它左右两侧必须 都 存在不相等邻居。
 *
 * 返回 nums 中峰和谷的数量。
 * @author Junho
 * @date 2022/3/20 10:36
 */
public class Main6027 {
    public int countHillValley(int[] nums) {
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++ ){
            if(i - 1 >= 0 && nums[i] == nums[i-1])
                continue;
            if(i == 0 || i == nums.length - 1)
                continue;
            int left = i - 1 ;
            int right = i + 1;
            while (left >= 0 && nums[left] == nums[i]){
                left--;
            }
            while (right < nums.length && nums[right] == nums[i]){
                right++;
            }
            if((left >= 0 && right < nums.length)&&
                    ((nums[left] > nums[i] && nums[right] > nums[i])
                            || (nums[left] < nums[i] && nums[right] < nums[i])
                    )){
                res++;
                // System.out.println(nums[i]);
            }
        }
        return res;
    }
}
