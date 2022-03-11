package lc_2_Interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Main46 {
    boolean[] flag;
    int[] nums;
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] n) {
        nums = n;
        flag = new boolean[nums.length];
        dfs(0);
        return res;
    }
    public void dfs(int idx){
        if(idx == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++ ){
            if(!flag[i]){
                flag[i] = true;
                path.add(nums[i]);
                dfs(idx + 1);
                path.remove(path.size()-1);
                flag[i] = false;
            }
        }
    }
}
