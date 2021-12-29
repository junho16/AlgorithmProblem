package leetcode;

import java.util.*;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 */
public class Main216 {
    static boolean[] flag = new boolean[10];
    static List<Integer> path = new ArrayList();
    static List<List<Integer>> res = new ArrayList<>();
    // static Set<ArrayList<Integer>> ress = new HashSet<>();
    static int n;
    static int k;
    public List<List<Integer>> combinationSum3(int kk, int nn) {
        n = nn;
        k = kk;
//        path.add(1);
//        flag[1] = true;
//        dfs(1 , 1);
        dfs(0, 0);

        HashSet<List> set = new HashSet();
        for(List list : res){
            Collections.sort(list);
            set.add(list);
        }
        res.clear();
        for(List list : set){
            res.add(list);
            for(Object i:list){
                System.out.print(i+" ");
            }
            System.out.println( );
        }


        return res;
    }
    public void dfs(int num , int sum){
        if( num == k ) {
            // System.out.println(  " 11");
            // for(Integer i : path){
            //     System.out.print(  i+" ");
            // }
            // System.out.println( );
            if(sum == n){
                // System.out.println(  " 22");
                ArrayList tmp = new ArrayList();
                tmp.addAll(path);
                res.add(tmp);
//                res.add(tmp);

                // System.out.print((int) path.get(path.size()-1)+" ");

                // flag[(int) path.get(path.size()-1)] = false;
                // path.remove(path.size()-1);
                // return;
            }
            // System.out.print((int) path.get(path.size()-1)+" ");
            return;
        }

        for(int i = 1 ;i <=9 ;i ++){
            if(!flag[i]){
                path.add(i);
                flag[i] = true;
                dfs(num+1 , sum+i);

                flag[(int) path.get(path.size()-1)] = false;
                path.remove(path.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Main216 main = new Main216();
        main.combinationSum3(3, 9);
    }
}
