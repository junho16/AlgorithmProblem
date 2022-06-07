package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 差分:差分的思想：已知数组A 构造数组B满足 ai = b1 + b2 + ... + bi(也就是说 a 是作为 b 的前缀和 则 ==》 b 称为 a 的差分)
 *  最常用的功能: 在 O（1）时间复杂度下给 l,r 范围内 A 数组内元素 + c
 *  ==》某个数组在某个区间范围内都加上一个数
 *
 * 本题 可以用差分 结合 treemap做 ，因为不能开一个10的9次方的数组，又因为 绝大部分位置都是 0 ， 因此可以只treemap位置上有数的位置（map中存的值 ==>由于需要从前往后算 因此要用treemap）
 * 731. 我的日程安排表 II
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
 *
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 *
 * 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
 *
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
 *
 * 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 *
 * @author Junho
 * @date 2022/6/7 9:19
 */
public class Main731 {

    public Main731() {

    }

    Map<Integer , Integer> map = new TreeMap<>();

    public boolean book(int start, int end) {
        map.put(start , map.getOrDefault(start , 0) + 1);
        map.put(end , map.getOrDefault(end , 0) - 1);
        int sum = 0;
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            sum += entry.getValue();
            if(sum >= 3){
                map.put(start , map.get(start) - 1);
                map.put(end , map.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}
