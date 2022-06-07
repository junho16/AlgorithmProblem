package interview.lc_2_Interview;

import java.util.*;

/**
 * 554. 砖墙
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。
 *
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 * 1 2 2 1
 */
public class Main554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer , Integer> map = new HashMap();
        int length = 0;
        for(int i = 0 ; i < wall.get(0).size() ; i++){
            length += wall.get(0).get(i);
        }
        for(int i = 0 ; i < wall.size() ; i++){
            int sum = 0;
            for(int j = 0 ; j < wall.get(i).size() ; j++){
                sum += wall.get(i).get(j);
                if(sum != length)
                    map.put(sum , map.getOrDefault(sum , 0) + 1 );
            }
        }
        // for(Integer i : map.keySet() ){
        //     System.out.println(i+" "+map.get(i));
        // }


        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer , Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        // for(Map.Entry i : list){
        //     System.out.println( " " + (i.getKey() + " " + i.getValue()));
        // }
        return list.size() == 0 ? wall.size()
                : wall.size() - (list.get(list.size() - 1).getValue());

    }
}
