package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 *
 * @author Junho
 * @date 2022/7/8 21:48
 */
public class Main010 {
    // 用hash O(n)
    public int subarraySum(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();
        int[] sumPri = new int[nums.length + 1] ;
        sumPri[0] = 0;
        for(int i = 1; i < sumPri.length; i++ ){
            sumPri[i] = sumPri[i-1] + nums[i-1];
        }
        int res = 0;
        map.put(0 , 1);
        for(int i = 1 ; i < sumPri.length ; i++){

            res += map.getOrDefault(sumPri[i] - k , 0);
            map.put(sumPri[i] , map.getOrDefault(sumPri[i]  , 0) + 1);

        }
        return res;



//      不用hash n^2
//        int[] prefixSum = new int[nums.length+1];
//        prefixSum[0] = 0;
//        for(int i = 1; i < nums.length+1 ;i++){
//            prefixSum[i] = prefixSum[i-1] + nums[i-1];
//        }
//        // for(int i = 0 ; i < prefixSum.length ; i++){
//        //     System.out.print(prefixSum[i] + " ");
//        // }
//        int res = 0;
//        for(int i = 0 ; i < nums.length ; i++){
//            for(int j = i; j < nums.length ; j++ ){
//                if(prefixSum[j+1] - prefixSum[i] == k){
//                    res+=1;
//                }
//            }
//        }
//        return res;

//        注意和上题不同 这里滑动窗口无法保证加入值是增大 减少值是减小
//        int left = 0 , res = 0 , sum = 0;
//        for(int right = 0 ; right < nums.length ;  ){
//            sum += nums[right++];
//
//            while (sum > k && left <= right ){
//                sum -= nums[left++];
//            }
//            if(sum == k && left < nums.length)
//                res++;
//        }
//        return res;
    }
}
