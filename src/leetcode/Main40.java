package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 虽然是一个经典的dfs问题 但是需要注意的点还挺多的 比如说某一个数字出现的次数应该是从0开始 所以dfs必须在path add之前
 *  dfs( k + 1, target - candidates[idx] * i);
 *  path.add(candidates[idx]);
 *
 *  还有对于计算下一个数个数这个问题由于是0 1 2...所以应该是 <=
 *
 *  巧妙的使用到target 从 target开始往少了减
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。
 */
public class Main40 {
    public static void main(String[] args) {
        Main40 main40 = new Main40();
        main40.combinationSum2(new int[]{10,1,2,7,6,1,5},
        8);
    }
    public int target;
    public int[] candidates;
    public List<Integer> path;
    public List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] can, int tar) {
        candidates = can;
        Arrays.sort(candidates);
        target = tar;
        path = new ArrayList<>();
        res = new ArrayList<>();
        dfs(0 , target);
        return res;
    }
    void dfs(int idx , int target){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(idx == candidates.length)
            return;
        int k = idx;
        while (k + 1 < candidates.length && candidates[k + 1] == candidates[k])
            k++;
        int u = k - idx + 1;
        for(int i = 0 ; i <= u && target - candidates[idx] * i >= 0; i++ ){
            dfs( k + 1, target - candidates[idx] * i);
            path.add(candidates[idx]);
        }
        for(int i = 0 ; i <= u && target - candidates[idx] * i >= 0; i++ ){
            path.remove(path.size() - 1);
        }
    }
//        sum += candidates[idx];
//        path.add(candidates[idx]);
//
//        for(Integer ii : path ){
//            System.out.print(ii+" ");
//        }
//        System.out.println();
//        if(sum > target){
//            sum -= candidates[idx];
//            if(path.size()>0) path.remove(path.size() - 1);
//            return;
//        }
//        if(sum == target){
//            ArrayList tmp = new ArrayList();
//            for(Integer i : path )
//                tmp.add(i);
//            res.add(tmp);
//            sum -= candidates[idx];
//            if(path.size()>0) path.remove(path.size() - 1);
//            return;
//        }
//        for(int i = 0; i < candidates.length ;i++){
//            if(!visited[i]){
//                visited[i] = true;
//                dfs(i , sum);
//                visited[i] = false;
//                if(path.size()>0) path.remove(path.size() - 1);
//                sum -= candidates[i];
//            }
//        }
//         sum -= candidates[idx];
//         if(path.size()>0) path.remove(path.size() - 1);

}
