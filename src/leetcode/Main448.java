package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * @author Junho
 * @date 2022/5/30 17:13
 */
public class Main448 {
    /**
     * 类似与442 通过修改原地数组判断是否有改变过
     * 对于本题
     *  遍历数组中每一个值，假设当前值作为索引（绝对值）的位置上（因为最大为nums.length）的值非负，则将其设置为其相反数，如果是负值说明此（索引）值已经出现过 则不管
     *  此时已经将所有存在的值当做下标进行标记（标记位负）
     *  再遍历一遍 此时统计值依旧是正的话 则加入res
     *  加入res[下标+1] （下标刚才减一了 所以要加上（实际上是因为 长度是1~n 而不是0~n-1））
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            int x = Math.abs(nums[i]) - 1;
            if(nums[x] > 0){
                nums[x] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }
}
