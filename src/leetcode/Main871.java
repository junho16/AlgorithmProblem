package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 871. 最低加油次数
 * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 *
 * 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。
 *
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
 *
 * 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 *
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 *
 * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 *
 * @author Junho
 * @date 2022/7/8 16:36
 */
public class Main871 {


    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        //存加油站下标
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int start = 0;
        int res = 0 ;
        for(int i = 0 ; i < stations.length ; i++ ){
            while(stations[i][0] - start > startFuel){
                if(queue.size() == 0){
                    return -1;
                }else{
                    startFuel +=  queue.poll() ;
                    res++;
                }
            }
            //将此加油站加进去
            queue.add(stations[i][1]);

            //油量
            startFuel -= (stations[i][0] - start);

            //位置
            start = stations[i][0];


            if(startFuel >= target - start)
                return res;
        }
        while( startFuel < target - start ){
            if(queue.size() == 0){
                return -1;
            }else{
                startFuel += queue.poll() ;
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        System.out.println(minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));
        System.out.println(minRefuelStops(100, 50, new int[][]{{25,50},{50,25}}));
    }
}
