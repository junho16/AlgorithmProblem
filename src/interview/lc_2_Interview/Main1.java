package interview.lc_2_Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */
public class Main1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            ArrayList list = map.getOrDefault(nums[i] , new ArrayList());
            list.add(i);
            map.put(nums[i] , list );
        }
        Arrays.sort(nums , 0 , nums.length );
        int[] res = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            if(target == 2 * nums[i] && map.get(nums[i]).size() >= 2 ){
                System.out.println(1);
                res[0] = map.get(nums[i]).get(0);
                res[1] = map.get(nums[i]).get(1);
                return res;
            }
            int l = 0 , r = nums.length - 1;
            while (l < r){
                int mid = (l + r + 1) >> 1;
                if(nums[mid] > target - nums[i])
                    r = mid - 1;
                else
                    l = mid;
            }
            if(l != i && nums[l] == nums[r]  && nums[l] == (target - nums[i])){
                res[0] = map.get(nums[l]).get(0);
                res[1] = map.get(nums[i]).get(0);
                return res;
            }
        }
        return null;
    }
}
