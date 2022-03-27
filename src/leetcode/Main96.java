package leetcode;

import javax.swing.plaf.basic.BasicIconFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * @author Junho
 * @date 2022/3/24 20:44
 */
public class Main96 {
    Map<String, Integer> map;
    public int numTrees(int n) {
        map = new HashMap<>();
        return dfs(1 , n);
    }

    /**
     * 题目的重点是：left > right的时候要记得add一个null值，因为需要某一个子树需要是null 在此处就是：0
     * @param left
     * @param right
     * @return
     */
    int dfs(int left  , int right ){
        if(map.containsKey(left + " " + right)){
            return map.get(left + " " + right);
        }
        if(left > right){
            return 0;
        }
        if(left == right){
            return 1;
        }
        int res = 0;
        for(int i = left ; i <= right ; i++ ){
            int l = dfs(left , i - 1);
            int r = dfs(i + 1 , right );
            if(l != 0 && r != 0){
                res += l * r;
            }
            if(l == 0 && r != 0){
                res += r;
            }
            if(l != 0 && r == 0){
                res += l;
            }
        }
        map.put(left + " " + right , res);
        return res;
    }
}
