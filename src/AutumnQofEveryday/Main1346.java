package AutumnQofEveryday;

import java.util.*;

/**
 * 1346. 检查整数及其两倍数是否存在
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 *
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 */
public class Main1346 {
    public boolean checkIfExist(int[] arr) {
        Map<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            List list = map.getOrDefault(arr[i] , new ArrayList());
            list.add(i);
            map.put(arr[i] , list);
        }
//        Set set = new HashSet();
//        for(int i = 0 ; i < arr.length; i++){
//            set.add(arr[i]);
//        }
        for(int i = 0 ; i < arr.length ;i++ ){
            if(map.containsKey(arr[i] * 2)){
                List<Integer> list = map.get(arr[i] * 2);
                for(int j = 0 ; j < list.size() ; j++ ){
                    if(list.get(j) != i){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
