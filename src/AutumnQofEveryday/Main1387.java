package AutumnQofEveryday;

import java.util.*;

/**
 * 1387. 将整数按权重排序
 * 我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：
 *
 * 如果 x 是偶数，那么 x = x / 2
 * 如果 x 是奇数，那么 x = 3 * x + 1
 * 比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。
 *
 * 给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。
 *
 * 请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
 *
 * 注意，题目保证对于任意整数 x （lo <= x <= hi） ，它变成 1 所需要的步数是一个 32 位有符号整数。
 * @author Junho
 * @date 2022/9/16 17:09
 */

public class Main1387 {
    class Node{
        int val;
        int idx;
        public Node(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    public int getKth(int lo, int hi, int k) {
        List<Node> list = new ArrayList<>();
        for(int i = lo ; i <= hi ; i++ ){
            list.add(new Node(getStep(i) , i));
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.val != o2.val){
                    return o1.val - o2.val;
                }else{
                    return o1.idx - o2.idx;
                }
            }
        });
        return list.get(k-1).idx;
    }

    public int getStep(int num){
        int res = 0 ;
        while (num != 1){
            if(num % 2 == 0){
                num = num / 2;
            }else{
                num = 3 * num + 1;
            }
            res++;
        }
        return res;
    }
//    public int getKth(int lo, int hi, int k) {
//        Map<Integer , List<Integer>> map = new HashMap<>();
//        for(int i = lo ; i <= hi ; i++ ){
//            int val = getStep(i);
//            List<Integer> list = map.getOrDefault(val , new ArrayList<>());
//            list.add(i);
//            map.put(val , list);
//        }
//        List<Map.Entry<Integer , List<Integer>>> sortList = new ArrayList<>(map.entrySet());
//        Collections.sort(sortList , new Comparator<Map.Entry<Integer, List<Integer>>>() {
//            @Override
//            public int compare(Map.Entry<Integer, List<Integer>> o1, Map.Entry<Integer, List<Integer>> o2) {
//                return o1.getKey() - o2.getKey();
//            }
//        });
//        Map.Entry<Integer , List<Integer>> resentry = sortList.get(k - 1);
//        List<Integer> l = resentry.getValue();
//        for(Integer i : l ){
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        return resentry.getValue().get(0);
//
////        String[] strings = list.get(k-1).split(" ");
////        return Integer.parseInt(strings[1]);
//    }
//
//    public int getStep(int num){
//        int res = 0 ;
//        while (num != 1){
//            if(num % 2 == 0){
//                num = num / 2;
//            }else{
//                num = 3 * num + 1;
//            }
//            res++;
//        }
//        return res;
//    }

    int val;
}
