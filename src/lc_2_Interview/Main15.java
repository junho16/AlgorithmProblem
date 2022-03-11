package lc_2_Interview;

import java.util.*;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class Main15 {
//     ====下面这种做法是双指针 并且通过 判断是否和前一个元素相等来去重 ，时间复杂度比较低
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList t = new ArrayList();
        if(nums.length < 3)
            return res;
        Arrays.sort(nums , 0 , nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 )
                return res;
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int l = i + 1 , r = nums.length - 1;
            while (l < r){
                if(nums[i] + nums[l] + nums[r] == 0){
                    t = new ArrayList();
                    t.add(nums[i]);
                    t.add(nums[l]);
                    t.add(nums[r]);
                    res.add(t);
                    while (l < r && nums[l] == nums[l+1])
                        l++;
                    while (l < r && nums[r] == nums[r-1])
                        r--;
                    l++;
                    r--;
                }else if(nums[i] + nums[l] + nums[r] > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return res;
    }
// ====下面这种做法是双指针但是通过集合来去重 ，效率比较低下
//        Set<List<Integer>> resSet = new HashSet();
//        List<List<Integer>> res = new ArrayList<>();
//        if(nums.length < 3)
//            return res;
//        Arrays.sort(nums , 0 , nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            int l = i + 1 , r = nums.length - 1;
//            while (l < r){
//                if(nums[i] + nums[l] + nums[r] == 0){
//                    ArrayList t = new ArrayList();
//                    t.add(nums[i]);
//                    t.add(nums[l]);
//                    t.add(nums[r]);
//                    Collections.sort(t);
//                    resSet.add(t);
//                    l++;
//                    r--;
//                }else if(nums[i] + nums[l] + nums[r] > 0){
//                    r--;
//                }else{
//                    l++;
//                }
//            }
//        }
//        for(List<Integer> arr : resSet){
//            res.add(arr);
//        }
//        return res;



//  ====使用哈希表过不了完整的数据
//        Set<List<Integer>> resSet = new HashSet();
//        List<List<Integer>> res = new ArrayList<>();
//        Map<Integer , Integer> map  = new HashMap<>();
//        for(Integer i : nums){
//            map.put(i , map.getOrDefault(map.get(i) , 0) + 1);
//        }
//        for(Integer t : map.keySet()){
//            System.out.println(t+" "+map.get(t));
//        }
//        for(int i = 0 ; i < nums.length ; i++){
//            for(int j = 0 ; j < nums.length && i != j; j++ ){
//                if(((0 - nums[i] - nums[j] == nums[i] || 0 - nums[i] - nums[j] == nums[j])
//                        && map.get(0 - nums[i] - nums[j]) >= 2 )
//                ) {
//                    ArrayList t = new ArrayList();
//                    t.add(nums[i]);
//                    t.add(nums[j]);
//                    t.add(0 - nums[i] - nums[j]);
//                    Collections.sort(t);
//                    resSet.add(t);
//                }else{
//                    if(!(0 - nums[i] - nums[j] == nums[i] || 0 - nums[i] - nums[j] == nums[j]) && map.containsKey(0 - nums[i] - nums[j])){
//                        ArrayList t = new ArrayList();
//                        t.add(nums[i]);
//                        t.add(nums[j]);
//                        t.add(0 - nums[i] - nums[j]);
//                        Collections.sort(t);
//                        resSet.add(t);
//                    }
//                }
//            }
//        }
//        for(List<Integer> arr : resSet){
//            res.add(arr);
//        }
//        return res;


}
