package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 436. 寻找右区间
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 *
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
 *
 * 返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 *
 * @author Junho
 * @date 2022/5/20 21:12
 */
public class Main436 {
    class Node{
        int[] arr;
        int idx;
        public Node(int[]arr , int idx){
            this.arr = arr;
            this.idx = idx;
        }
    }
    public int[] findRightInterval(int[][] inter) {
        Node[] intervals = new Node[inter.length];
        for(int i = 0; i < inter.length ; i++){
            intervals[i] = new Node(inter[i] , i);
        }
        Arrays.sort(intervals, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                // if(o1.arr[0] == o2.arr[0]){
                //     return o1.idx - o2.idx;
                // }else{
                return o1.arr[0] - o2.arr[0];
                // }
            }
        });
        int[] res = new int[inter.length];
        for(int i = 0 ; i < inter.length ; i++){
            int target = inter[i][1];
            int l = 0 , r = inter.length - 1;
            while (l < r ){
                int mid = l + r >> 1;
                if(intervals[mid].arr[0] < target){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }

            res[i] = intervals[l].arr[0] >= target ?  intervals[l].idx : -1;
        }
//        for(int i =0 ; i < intervals.length ; i++){
//            System.out.println(intervals[i].arr[0] + " " + intervals[i].arr[1] + " " + intervals[i].idx);
//        }
//        System.out.println("====");
//        for(int i =0 ; i < inter.length ; i++){
//            System.out.println(inter[i][0] + " " + inter[i][1]);
//        }
        return res;
    }
}
