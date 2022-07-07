package leetcode;

import java.util.*;

/**
 * 826. 安排工作以达到最大收益
 * 你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:
 *
 * difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
 * worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
 * 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。
 *
 * 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。
 * 返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。
 * @author Junho
 * @date 2022/6/20 14:56
 */
public class Main826 {
    class Node{
        int diff;
        int profit;
        public Node(int d , int p){
            this.diff = d;
            this.profit = p;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
//        List<Node> list = new ArrayList<>();
        Node[] list = new Node[difficulty.length];
        for(int i = 0 ; i < difficulty.length ; i++){
//            list.add(new Node(difficulty[i] , profit[i]));
            list[i] = new Node(difficulty[i] , profit[i]);
        }
        Arrays.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                // if(o1.diff == o2.diff){
                //     return o2.profit - o1.profit;
                // }
                return o1.diff - o2.diff;
            }
        });
        int res = 0;
        for(int i = 0; i < worker.length ; i++){
            int l = 0 , r = list.length - 1;
            while (l < r){
                int mid = l + r + 1>> 1;
                if(list[mid].diff <= worker[i]){
                    l = mid;
                }else{
                    r = mid - 1;
                }
            }
            int max = 0;
            for(int k = 0; k <= l ;k++){
                if(list[k].diff <= worker[i])
                    max = Math.max(max, list[k].profit);
            }
            // System.out.println(l +" " + r +" " + max);
            res += max;
        }
        return res;
    }
}
