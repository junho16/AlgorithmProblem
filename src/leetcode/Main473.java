package leetcode;

import java.util.List;

/**
 * 473. 火柴拼正方形
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。
 * 你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 *
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 *
 * @author Junho
 * @date 2022/6/1 16:06
 */
public class Main473 {
    int[] match;
//    boolean res = false;
    int tarSum;
    public boolean makesquare(int[] matchsticks) {
        match = matchsticks;
        int sum = 0;
        for(int i = 0 ; i < matchsticks.length ; i++)
            sum += matchsticks[i];
        if(sum == 0 || sum % 4 != 0)
            return false;
        tarSum = sum / 4;
        for(int i = 0; i < matchsticks.length  ;i++){
            if(matchsticks[i] > tarSum){
                return false;
            }
        }
//        dfs(0 , 0 ,0 , 0 ,0 );
//        return res;
        return dfs(0 , 0 ,0 , 0 ,0 );
    }

    /**
     * 假设可以搜到最后一个位置 则说明当前的分配方式是可行的
     * 依次将当前index的长度分配给第一条边
     * @param index
     * @param l1
     * @param l2
     * @param l3
     * @param l4
     * @return
     */
    boolean dfs(int index , int l1  , int l2 , int l3 , int l4){
        if(index == match.length ){
            return true;
        }

        if(l1 + match[index] <= tarSum && dfs(index + 1 , l1 + match[index] , l2 , l3 , l4 ))
            return true;

        if(l2 + match[index] <= tarSum && dfs(index + 1 , l1, l2 + match[index] , l3 , l4 ))
            return true;

        if(l3 + match[index] <= tarSum && dfs(index + 1 , l1 , l2 , l3 + match[index], l4 ))
            return true;

        if(l4 + match[index] <= tarSum && dfs(index + 1 , l1 , l2 , l3 , l4 + match[index]))
            return true;

        return false;
    }
}
