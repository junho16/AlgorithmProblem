package leetcode;

import java.util.Arrays;

/**
 * 376. 摆动序列
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 *
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 *
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 *
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 *
 * @author Junho
 * @date 2022/4/26 11:24
 */
public class Main376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
//    数据没有过全 22/26。。。这种情况上哪找原因啊 吐了
//    public int wiggleMaxLength(int[] nums) {
//        if(nums.length == 1)
//            return nums.length;
//        if(nums.length == 2)
//            return nums[1] == nums[0] ? 1 : nums.length;
//        // if(nums.length == 3){
//        //     if((nums[2] - nums[1]) * (nums[1] - nums[0]) < 0 )
//        //         return 3;
//        //     else{
//        //         return 2;
//        //     }
//        // }
//        boolean flag = false;
//        int[] dp = new int[nums.length + 1];
//        Arrays.fill(dp , 1);
//        for(int i = 1; i < nums.length - 1 ;i++){
//            if(nums[i] != nums[i-1] || nums[i] != nums[i+1])
//                flag = true;
//            if((nums[i] - nums[i-1]) * (nums[i + 1] - nums[i]) < 0 )
//                dp[i] = Math.max(dp[i-1] , dp[i-1] + 1);
//            else if((nums[i] - nums[i-1]) * (nums[i + 1] - nums[i]) > 0 ){
//                dp[i] = dp[i-1];
//            }
//        }
//        if(!flag)
//            return 1;
//        if((nums[nums.length - 1] - nums[nums.length - 2]) * (nums[nums.length - 2] - nums[nums.length - 3]) < 0 )
//            // return dp[nums.length - 2] + 1  ;
//            return dp[nums.length - 2] + 1 == 1?2:dp[nums.length - 2] + 1 ;
//        else
//            return dp[nums.length - 2] == 1?2:dp[nums.length - 2] + 1 ;
//        // return dp[nums.length - 2] ;
//    }
}
