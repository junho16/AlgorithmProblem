package leetcode;

import java.util.*;

/**
 * 1200. 最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * @author Junho
 * @date 2022/7/4 21:47
 */
public class Main1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        Map<Integer , List<List<Integer>>> map = new TreeMap<>();
        for(int i = 1 ; i < arr.length ; i++){
//            List<Integer> list = new ArrayList<>();
//            list.add(arr[i]);
//            list.add(arr[i-1]);
            if(map.containsKey(Math.abs(arr[i] - arr[i-1]))){
                map.get(Math.abs(arr[i] - arr[i-1])).add(Arrays.asList(arr[i-1] , arr[i]));
            }else{
                List<List<Integer>> l = new ArrayList<>();
                l.add(Arrays.asList(arr[i-1] , arr[i]));
                map.put(Math.abs(arr[i] - arr[i-1]) , l);
            }
//            map.put(arr[i] - arr[i-1] , map.getOrDefault( arr[i] - arr[i-1] , new ArrayList<>() ).add(list));
        }
        for(Map.Entry<Integer, List<List<Integer>>> entry : map.entrySet()){
            System.out.println(entry.getKey());
        }
        List<Map.Entry<Integer, List<List<Integer>>>> res = new ArrayList(map.entrySet());
        return res.size() == 0 ? new ArrayList<>() : res.get(0).getValue();
    }
}
