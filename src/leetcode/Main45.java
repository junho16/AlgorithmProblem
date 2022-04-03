package leetcode;

/**
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 *
 * @author Junho
 * @date 2022/3/29 21:27
 */
public class Main45 {
    public int jump(int[] nums) {
        int res = 0;
        int i = 0;
        if(nums.length == 1)
            return 0;
        while (i < nums.length){
            int maxTmp = 0;
            int flagIdx = i;
            for(int j = 1; j <= nums[i] ; j++){
                if(i + j >= nums.length - 1){
                    return res + 1;
                }
                if(j + i + nums[i+j]> maxTmp){
                    maxTmp = j + i + nums[i+j];
                    flagIdx = j+i;
                }
            }
            System.out.print(maxTmp);
            i = flagIdx;
            res++;
            if(i >= nums.length - 1 )
                return res;

        }
        return res;
    }
}
