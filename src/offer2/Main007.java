package offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c
 * 使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 * @author Junho
 * @date 2022/6/21 20:13
 */
public class Main007 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0 ;i < nums.length ; i++){
            if(nums[i] > 0 )
                return res;
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            // l 从 i+1 开始 ， 因为 通过控制最小的数 就可以不用set去重，因为找结果的时候 最小的值已经确定了 后面再找两个数 有就有 没有就没有
            int l = i + 1 , r = nums.length - 1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while(l < r && nums[l] == nums[l+1])
                        l++;
                    while(l < r && nums[r] == nums[r-1])
                        r--;
                    l++;
                    r--;
                }else if(nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }else if(nums[i] + nums[l] + nums[r] > 0){
                    r--;
                }
            }
        }
        return res;
    }
}
