package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. 用户分组
 * 有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。
 *
 * 给定一个整数数组 groupSizes ，其中 groupSizes[i] 是第 i 个人所在的组的大小。例如，如果 groupSizes[1] = 3 ，则第 1 个人必须位于大小为 3 的组中。
 *
 * 返回一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。
 *
 * 每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中。如果有多个答案，返回其中 任何 一个。可以 保证 给定输入 至少有一个 有效的解。
 *
 * @author Junho
 * @date 2022/8/13 10:31
 */
public class Main1282 {
    public static void main(String[] args) {
        Main1282 main1282 = new Main1282();
        System.out.println(main1282.groupThePeople(new int[]{3,3,3,3,3,1,3}));
    }
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < groupSizes.length ;i++ ){
            List<Integer> list = map.getOrDefault(groupSizes[i] , new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i] , list);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer , List<Integer>> entry : map.entrySet()){
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < entry.getValue().size() ; i ++){
                list.add(entry.getValue().get(i));
                if(list.size() == entry.getKey()){
                    res.add(list);
                    list = new ArrayList<>();
                }
            }
        }
        return res;
    }
}
