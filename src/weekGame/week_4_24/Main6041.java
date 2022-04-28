package weekGame.week_4_24;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，
 * 按升序排列 返回一个数组，数组中的每个元素在 nums 所有数组 中都出现过。
 *
 * @author Junho
 * @date 2022/4/24 10:32
 */
public class Main6041 {
    public List<Integer> intersection(int[][] nums) {
        int[] flag = new int[1005];
        for(int[] n : nums){
            for(int i = 0 ; i < n.length ; i++){
                flag[n[i]]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < flag.length; i++){
            if(flag[i] == nums.length){
                res.add(i);
            }
        }
        return res;

    }
}
