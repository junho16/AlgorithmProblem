package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 532. 数组中的 k-diff 数对
 * 给你一个整数数组 nums 和一个整数 k，请你在数组中找出 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *
 * k-diff 数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
 *
 * 0 <= i, j < nums.length
 * i != j
 * nums[i] - nums[j] == k
 * 注意，|val| 表示 val 的绝对值。
 *
 * @author Junho
 * @date 2022/6/16 16:38
 */
public class Main532 {
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++ ){
            if(set.contains(nums[i] + k)){
                res.add(nums[i]);
            }
            if(set.contains(nums[i] - k)){
                res.add(nums[i] - k);
            }
            set.add(nums[i]);
        }
//        for(Integer s : res){
//            System.out.println(s);
//        }
        return res.size()  ;
//        Set<Integer> set = new HashSet<>();
//        Set<String> res = new HashSet<>();
//        Set<String> resTmp = new HashSet<>();
//
//        for(int i = 0 ; i < nums.length ; i++ ){
//            if(set.contains(nums[i] + k)){
//                if(nums[i] == (nums[i] + k) ){
//                    resTmp.add(nums[i] + " " + (nums[i] + k));
//                }else{
//                    res.add(nums[i] + " " + (nums[i] + k));
//                    res.add((nums[i] + k) + " " + (nums[i]));
//                }
//
//            }else if(set.contains(nums[i] - k)){
//                if(nums[i] == (nums[i] - k)){
//                    resTmp.add(nums[i] + " " + (nums[i] + k));
//                }else{
//                    res.add(nums[i] + " " + (nums[i] - k));
//                    res.add((nums[i] - k) + " " + (nums[i]));
//                }
//
//            }
//            set.add(nums[i]);
//        }
//        for(String s : res){
//            System.out.println(s);
//        }
//        return res.size() / 2 + resTmp.size();
    }
}