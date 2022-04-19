package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 * @author Junho
 * @date 2022/4/19 11:40
 */
public class Main386 {
    List<Integer> res = new ArrayList<>();
    int maxNum;
    public List<Integer> lexicalOrder(int n) {
        maxNum = n;
        for(int i = 1 ; i <= 9 ; i++){
            dfs(i);
        }
        return res;
    }
    void dfs(int n){
        if(n > maxNum)
            return;
        res.add(n);
        for(int i = 0 ; i <= 9 ; i++){
            dfs(n * 10 + i);
        }
    }
}
