package leetcode;

import sun.print.BackgroundLookupListener;

import java.util.*;

/**
 *310. 最小高度树
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 *
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 *
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 *
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 *
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 *
 * @author Junho
 * @date 2022/4/8 14:29
 */
public class Main310 {
    public static void main(String[] args) {
        Main310 main310 = new Main310();
        main310.findMinHeightTrees(4 , new int[][]{
                {1,0},
                {1,2},
                {1,3}
        });

    }
    class Node{
        int idx;
        int val;
        public Node(int idx , int val){
            this.idx = idx;
            this.val = val;
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer,List<Integer>>graph = new HashMap<>();
        int[] inDegree = new int[n];
        for(int[] edge:edges){
            int a = edge[0];
            int b = edge[1];
            graph.putIfAbsent(a,new ArrayList<>());
            graph.putIfAbsent(b,new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
            ++inDegree[a];
            ++inDegree[b];
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inDegree[i]<=1){
                queue.offer(i);
                --inDegree[i];
            }
        }

        List<Integer> ans = new ArrayList(queue);
        while(!queue.isEmpty()){
            int size = queue.size();
            ans = new ArrayList(queue);
            for(int i = 0; i < size; i++){
                int top = queue.poll();
                if(!graph.containsKey(top)) continue;
                for(Integer next:graph.get(top)){
                    --inDegree[next];
                    if(inDegree[next]==1){
                        queue.offer(next);
                    }
                }
            }

        }
        return ans;
    }

//  哭了 ，BFS也过不去
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        List<List<Integer>> maplist = new ArrayList<>();
//        Queue<Integer> queue = new LinkedList<>();
//        boolean[] flag = new boolean[n];
//        int org;
//        int[] res = new int[n];
//        for(int i = 0 ; i < n ;i++)
//            maplist.add(new ArrayList<>());
//        for(int i = 0 ; i < edges.length ;i++){
//            int a = edges[i][0];
//            int b = edges[i][1];
//            maplist.get(a).add(b);
//            maplist.get(b).add(a);
//        }
//        for(int i = 0 ;i < n ;i++){
//            org = i ;
//            queue = new LinkedList<>();
//            flag = new boolean[n];
//            int maxDepth = 0;
//
//            queue.add(i);
//            flag[i] = true;
//            int size = 1;
//
//            while (!queue.isEmpty()){
//                int num = 0;
//                System.out.println(i+" "+size);
//                for(int k = 0; k < size ; k++){
//                    int tmp = queue.poll();
//                    List<Integer> list = maplist.get(tmp);
//                    for(int l = 0 ;l < list.size() ;l++){
//                        if(!flag[list.get(l)]){
//                            queue.add(list.get(l));
//                            flag[list.get(l)] = true;
//                            num++;
//                        }
//                    }
//                }
//                maxDepth++;
//                size = num;
//            }
//            res[i] = maxDepth;
//        }
//        for(int i = 0 ;i < res.length ;i ++){
//            System.out.println(res[i]);
//        }
//
//        Map<Integer , Integer> treeMap = new TreeMap<>();
//        for(int i = 0 ;i < res.length ;i ++){
//            treeMap.put(i , res[i]);
//        }
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(treeMap.entrySet());
//
//        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
//            //升序排序
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });
//
//        for (Map.Entry<Integer, Integer> e: list) {
//            System.out.println(e.getKey()+":"+e.getValue());
//        }
//        List<Integer> returnRes = new ArrayList<>();
//        int idx = 0;
//        returnRes.add(list.get(idx).getKey());
//        while (idx + 1 < list.size() && list.get(idx + 1).getValue().equals(list.get(idx).getValue())){
//            returnRes.add(list.get(idx + 1).getKey());
//            idx += 1;
//        }
//        return returnRes;
//    }
//  下面的DFS过不完所有数据 67/70
//    class Node{
//        int idx;
//        int val;
//        public Node(int idx , int val){
//            this.idx = idx;
//            this.val = val;
//        }
//    }
//    boolean[] flag;
//    Map<Integer , Integer> map;
//    List<List<Integer>> maplist = new ArrayList<>();
//    int[] res;
//    int org;
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        res = new int[n];
//        flag = new boolean[n];
//
//        for(int i = 0 ; i < n ;i++)
//            maplist.add(new ArrayList<>());
//        for(int i = 0 ; i < edges.length ;i++){
//            int a = edges[i][0];
//            int b = edges[i][1];
//
//
//            maplist.get(a).add(b);
//            maplist.get(b).add(a);
//
//        }
//        for(int i = 0 ; i < n ;i++ ){
//            org = i;
//            flag[i] = true;
//            dfs(i , 0);
//            flag[i] = false;
//        }
//
//        // Arrays.sort(res , 0 , res.length);;
//        // for(int i =0 ; i< res.length ;i++){
//        //     System.out.println(res[i]);
//        // }
//        Node[] nodes = new Node[n];
//        for(int i = 0 ; i < res.length ; i++){
//            nodes[i] = new Node(i , res[i]);
//        }
//        Arrays.sort(nodes, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return o1.val - o2.val;
//            }
//        });
//        // for(int i = 0 ;i < nodes.length ;i++){
//        //     System.out.println(nodes[i].idx+" " +nodes[i].val);
//        // }
//        List<Integer> returnRes = new ArrayList<>();
//        int idx = 0;
//        returnRes.add(nodes[idx].idx);
//        while (idx + 1 < nodes.length && nodes[idx + 1].val == nodes[idx].val){
//            returnRes.add(nodes[idx + 1].idx);
//            idx += 1;
//        }
//        return returnRes;
//    }
//    public void dfs(int idx  , int sum){
//
//        List<Integer> list = maplist.get(idx);
//        boolean f = false;
//        for(int i = 0 ; i < list.size() ; i++){
//            // System.out.print(list.get(i) + " ");
//            if(!flag[list.get(i)])
//                f = true;
//        }
//        // System.out.println();
//        if(!f){
//            res[org] = Math.max(res[org] , sum);
//            return;
//        }
//        for(int i = 0 ; i < list.size() ; i++){
//            if(!flag[list.get(i)]){
//                flag[list.get(i)] = true;
//                dfs(list.get(i) , sum + 1);
//                flag[list.get(i)] = false;
//            }
//        }
//    }
}
