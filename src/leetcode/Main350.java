package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * @author Junho
 * @date 2022/4/9 16:59
 */
public class Main350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer , Integer> map_1 = new HashMap<>();
        Map<Integer , Integer> map_2 = new HashMap<>();
        for(int i = 0 ; i < nums1.length ;i++ ){
            map_1.put(nums1[i] , map_1.getOrDefault(nums1[i] , 0 ) + 1);
        }
        for(int i = 0 ; i < nums2.length ;i++ ){
            map_2.put(nums2[i] , map_2.getOrDefault(nums2[i] , 0 ) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(Integer i : map_1.keySet()){
            if(map_2.containsKey(i)){
                int num = Math.min(map_1.get(i) , map_2.get(i));
                for(int j = 0 ; j < num ; j++){
                    list.add(i);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++ ){
            res[i] = list.get(i);
        }
        return res;
    }
}
