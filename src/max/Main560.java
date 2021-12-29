package max;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 */
public class Main560 {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length ;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i; j < nums.length ; j++ ){
                if(prefixSum[j] - prefixSum[i] == k){
                    res+=1;
                }
            }
        }
        return res;
    }
}
