package leetcode;

import java.util.*;

/**
 * 398. 随机数索引
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 *
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 *
 * @author Junho
 * @date 2022/4/25 9:06
 */
public class Main398 {

    Map<Integer , List<Integer>> map;
    public Main398(int[] nums) {
        map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            List<Integer> ltmp = map.getOrDefault(nums[i] , new ArrayList<>());
            ltmp.add(i);
            map.put( nums[i] , ltmp);
        }
    }

    public int pick(int target) {
        return map.get(target).get(new Random().nextInt(map.get(target).size()));
    }
}
