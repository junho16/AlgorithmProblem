package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二进制运算
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class Main56_2 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for(Integer num : nums){
            for(int j = 0; j < 32; j++) {
                count[j] += num & 1;
                num >>>= 1;
            }
            // int idx = 0;
            // for(int i = 0 ;i < integer.toString().length() ; i++) {
            //     count[idx++] = integer & 1;
            //     integer >>>= 1;
            // }
        }
        int res = 0 , m = 3;
        for(int i = 0 ; i < 32 ; i++){
            res <<= 1;
            res |= count[31 - i] % m;
        }
        return res;
    }
    public List<Integer> findDuplicates(int[] nums) {
        int[] numss = Arrays.copyOf(nums , nums.length);
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0 ; i < nums.length ; i++ ){
            while( i != nums[i] && nums[nums[i]] != nums[i])        {
                int tmp  = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = tmp;
            }
            if(i != nums[i]){
                res.add(nums[i]);
            }
        }
        return res;

    }
//    public int singleNumber(int[] nums) {
//        int[] counts = new int[32];
//        for(int num : nums) {
//            for(int j = 0; j < 32; j++) {
//                counts[j] += num & 1;
//                num >>>= 1;
//            }
//        }
//        int res = 0, m = 3;
//        for(int i = 0; i < 32; i++) {
//            res <<= 1;
//            res |= counts[31 - i] % m;
//        }
//        return res;
//    }
}
