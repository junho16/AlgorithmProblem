package leetcode;

import java.util.*;

/**
 * 621. 任务调度器
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 *
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的 最短时间 。
 *
 *
 * @author Junho
 * @date 2022/3/26 17:17
 */
public class Main621 {
    /**
     * 稍微分析一下：
     *  按照出现字母次数排序，假设出现次数最多的是A ，那么按照A的次数为标准来放任务
     *  假设出现了以A任务为标准的 全满的情况，则说明不会有待命的情况发生，则应该返回整个序列长度（下划线，这个需要画个图清楚一点）
     *  假设没有全满，则就说明有待命的情况，则应该是（最多任务量 - 1） * （冷却时间 + 1） + 多出来的任务数量（这个计算方式应该是：和A任务一样多数量的任务的个数）
     *  （注意一点：判别Integer时 是对象 equals 不是 ==，。。。）
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        TreeMap<Integer , Integer> treeMap = new TreeMap();
        for(int i = 0 ;i < tasks.length ; i++){
            treeMap.put(tasks[i] - 'A'  , treeMap.getOrDefault(tasks[i] - 'A' , 0) + 1);
        }
        List<Map.Entry<Integer,  Integer>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer ,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer , Integer> o1, Map.Entry<Integer , Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        // for(int i =0 ;i < list.size() ; i++){
        //     System.out.println(list.get(i).getKey() +" "+list.get(i).getValue() );
        // }
        int idx = 1 ;
        // System.out.println(list.get(0).getKey()+ " "+ list.get(0).getValue() );
        // System.out.println(list.get(1).getKey()+ " "+ list.get(1).getValue() );
        // System.out.println(list.get(0).getValue().equals(list.get(1).getValue() ));
        while (idx < list.size() && (list.get(idx).getValue().equals(list.get(0).getValue()))){
            // System.out.println("===");
            idx = idx+1;
        }
        // System.out.println(idx);
        return Math.max(tasks.length ,  (list.get(0).getValue() - 1) * (n + 1) + idx );
    }

}
