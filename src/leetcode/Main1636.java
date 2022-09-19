package leetcode;

import java.util.*;

/**
 * 1636. 按照频率将数组升序排序
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * 请你返回排序后的数组。
 * @author Junho
 * @date 2022/9/19 9:40
 */
public class Main1636 {
    public static void main(String[] args) {
        frequencySort(new int[]{1,1,2,2,2,3});
    }
    public static int[] frequencySort(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0 ) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() == o2.getValue()){
                    return o2.getKey() - o1.getKey();
                }else{
                    return o1.getValue() - o2.getValue();
                }
            }
        });
        int[] res = new int[nums.length];
        int idx = 0 ;
        for(Map.Entry<Integer , Integer> entry : list){
            for(int i = 0 ; i < entry.getValue() ; i++)
                res[idx++] = entry.getKey();
        }
        return res;
    }
}
