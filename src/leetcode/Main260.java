package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 异或运算
 * 260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * @author: hx
 * @date: 2021年10月30日 19:14
 */
public class Main260 {
    public static void main(String[] args) {
        int[] nums = { 1,2,1,3,2,5 };
        singleNumber(nums);
    }
    public static int[] singleNumber(int[] nums) {
        HashMap<Integer , Integer> hashMap = new HashMap();
        for(int i = 0 ;  i < nums.length ; i++){
            if(hashMap.containsKey(nums[i])){
                hashMap.remove(nums[i]);
            }else{
                hashMap.put(nums[i] , 1);
            }
        }


        int[] res = new int[2];
        int index = 0;
        for(Integer integer : hashMap.keySet()) {
            res[index++] =  integer;
        }
        return res;
    }
}
