package offer2;

/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * @author Junho
 * @date 2022/6/21 22:33
 */
public class Main008 {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0 , r = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (l <= r && r < nums.length){
            sum += nums[r];
            if(sum >= target){
                while (l <= r && sum - nums[l] >= target){
                    sum -= nums[l];
                    l++;
                }
                if(sum >= target){
                    //这里必须是判断min 因为 要求 >= target的最小值
                    res = Math.min(res ,r - l +1 );
                }
                r++;
            }else{
                r++;
            }
        }
        if(res == Integer.MAX_VALUE)    return 0;
        else    return res;
    }
//        int res =  Integer.MAX_VALUE;
//        int sum = 0 ;
//        for(int i = 0 , j = 0  ; i < nums.length ; i++){
//            sum += nums[i];
//            while(sum - nums[j] >= target){
//                sum -= nums[j];
//                j++;
//            }
//            if(sum >= target){
//                res = Math.min(res , j - i + 1 );
//            }
//        }
//        if(res == Integer.MAX_VALUE)    return 0;
//        else    return res;

}
