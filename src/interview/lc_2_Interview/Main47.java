package interview.lc_2_Interview;

import java.util.*;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class Main47 {
    public boolean[] flag;
    public List<Integer> path;
    public int[] nums;
    public List<List<Integer>> res;
    public Set<List<Integer>> set;
    public List<List<Integer>> permuteUnique(int[] n) {
        path = new ArrayList<>();
        res = new ArrayList<>();
        flag = new boolean[n.length];
        set = new HashSet<>();
        nums = n;
        Arrays.sort(nums, 0 , nums.length);
        dfs(0);
        for(List<Integer> list : set)
            res.add(list);
        return res;
    }
    public void dfs(int idx){
        if(idx == nums.length){
            set.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0 ;i < nums.length ; i++ ){
            if(!flag[i]){
                flag[i] = true;
                path.add(nums[i]);

                // int k = idx + 1;
                // while (k < nums.length && nums[k] == nums[idx])
                //     k++;
                // dfs(k);
                dfs(idx + 1);

                path.remove(path.size() - 1);
                flag[i] = false;
            }
        }
    }
}
