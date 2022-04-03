package weekGame.week_4_3;

import java.util.*;

/**
 * 5235. 找出输掉零场或一场比赛的玩家 显示英文描述
 * 通过的用户数2391
 * 尝试过的用户数2538
 * 用户总通过次数2395
 * 用户总提交次数3111
 * 题目难度Medium
 * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
 *
 * 返回一个长度为 2 的列表 answer ：
 *
 * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 *
 * 注意：
 *
 * 只考虑那些参与 至少一场 比赛的玩家。
 * 生成的测试用例保证 不存在 两场比赛结果 相同 。
 *
 * @author Junho
 * @date 2022/4/3 10:54
 */
public class Main5235 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> set = new HashSet<>();
        Map<Integer , Integer> lose = new HashMap<>();
        for(int i = 0 ; i < matches.length ; i++ ){
            int winer = matches[i][0];
            int loser = matches[i][1];
            set.add(winer);
            set.add(loser);
            lose.put(loser , lose.getOrDefault(loser , 0) + 1);
        }
        List<Integer> res_0 = new ArrayList<>();
        List<Integer> res_1 = new ArrayList<>();
        for(Integer i : set) {
            if(!lose.containsKey(i)){
                res_0.add(i);
            }
        }
        for(Integer i : lose.keySet()) {
            if(lose.get(i) == 1){
                res_1.add(i);
            }
        }
        Collections.sort(res_0);
        Collections.sort(res_1);
        List res = new ArrayList();
        res.add(res_0);
        res.add(res_1);
        return res;
    }
}
