package leetcode;

import java.util.*;

/**
 * 同 731 差分可做
 * 732. 我的日程安排表 III
 * 当 k 个日程安排有一些时间上的交叉时（例如 k 个日程安排都在同一时间内），就会产生 k 次预订。
 *
 * 给你一些日程安排 [start, end) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。
 *
 * 实现一个 MyCalendarThree 类来存放你的日程安排，你可以一直添加新的日程安排。
 *
 * MyCalendarThree() 初始化对象。
 * int book(int start, int end) 返回一个整数 k ，表示日历中存在的 k 次预订的最大值。
 *
 * @author Junho
 * @date 2022/6/6 18:17
 */
public class Main732 {

    public Main732() {
    }

    Map<Integer, Integer> map = new TreeMap<>();

    public int book(int start, int end) {
        map.put(start , map.getOrDefault(start ,0 ) + 1 );
        map.put(end , map.getOrDefault(end ,0 ) - 1 );
        int res = 0;
        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            sum += entry.getValue();
            res = Math.max(res , sum);
        }
        return res;
    }
}
