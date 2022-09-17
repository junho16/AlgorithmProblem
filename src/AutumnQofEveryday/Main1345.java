package AutumnQofEveryday;

import java.util.*;

/**
 * 1345. 跳跃游戏 IV
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 *
 * 每一步，你可以从下标 i 跳到下标 i + 1 、i - 1 或者 j ：
 *
 * i + 1 需满足：i + 1 < arr.length
 * i - 1 需满足：i - 1 >= 0
 * j 需满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 *
 * 注意：任何时候你都不能跳到数组外面。
 * @author Junho
 * @date 2022/9/14 22:14
 */
public class Main1345 {
    public int minJumps(int[] arr) {
        Map<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            List list = map.getOrDefault(arr[i] , new ArrayList());
            list.add(i);
            map.put(arr[i] , list);
        }
        int[] dist = new int[arr.length];
        Arrays.fill(dist , Integer.MAX_VALUE);

        Deque<Integer> deque = new LinkedList();
        deque.addLast(0);
        dist[0] = 0;

        while (!deque.isEmpty()){
            int t = deque.poll();
            for(int i = t - 1 ; i <= t + 1 ; i += 2){
                if(i >= 0 && i < arr.length && dist[i] > dist[t] + 1){
                    dist[i] = dist[t] + 1;
                    deque.addLast(i);
                }
            }
            int val = arr[t];
            if(map.containsKey(val)){
                List<Integer> list = map.get(val);
                for(int i = 0 ; i < list.size() ; i++){
                    if(dist[list.get(i)] > dist[t] + 1 ){
                        dist[list.get(i)] = dist[t] + 1;
                        deque.addLast(list.get(i));
                    }
                }
                map.remove(val);
            }
        }
        return dist[arr.length - 1];
    }
}