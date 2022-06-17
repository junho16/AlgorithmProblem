package leetcode;

/**
 * @author Junho
 * @date 2022/6/15 10:36
 */
public class Main1760 {
    int[] nums;
    int maxOperations;
    public int minimumSize(int[] nums_, int maxOperations_) {
        nums = nums_;
        maxOperations = maxOperations_;
        int left = 1 , right = 1;
        for(int i = 0 ; i < nums.length ; i++){
            right = Math.max(right , nums[i]);
        }
        while (left < right){
            int mid = left + right >> 1;
            if(check(mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int mid ){
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            //如果是有余数 算出的次数应该减一（如果小于mid 则不需要操作 就是+0 ， 如果大于mid 且有余数 则应该是商的上取整次数减一 因为一次操作可将数分成两份） ； 没有余数 则直接 减一
            sum += (nums[i]  % mid != 0 ? nums[i] / mid  : nums[i] / mid -1 );
            // sum+= (nums[i] - 1) / mid;
        }
        return sum <= maxOperations;
    }
}
