package leetcode;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 506. 相对名次
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 *
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 *
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 */
public class Main506 {
    public String[] findRelativeRanks(int[] score) {
        //存放的是下标和分数
        Map<Integer , Integer> map = new TreeMap();
        for(int i = 0 ;i < score.length ; i++){
            map.put(i+1 , score[i]);
        }
        ArrayList<Map.Entry> list = new ArrayList<>(map.entrySet());
        Comparator comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        Collections.sort(list , comparator);
        String[] res = new String[score.length];
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if(i == 0){
                res[(int) list.get(i).getKey()] = "Gold Medal";
            }else if(i == 1){
                res[(int) list.get(i).getKey()] = "Silver Medal";
            }else if(i == 2){
                res[(int) list.get(i).getKey()] = "Bronze Medal";
            }else {
                res[(int) list.get(i).getKey()-1] = (i+1)+"";
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey()+" "+list.get(i).getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        new Main506().findRelativeRanks(new int[]{5, 4, 3, 2, 1});
    }
}
