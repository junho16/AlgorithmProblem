package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class Main54 {

    /**
     * 通过剪枝来做：
     */
    int res = 0;
    int target = 0;
    public int kthLargest(TreeNode root, int k) {
        target = k;
        dfs2(root);
        return res;
    }
    public void dfs2(TreeNode root){
        if (root == null || target < 0) return;
        dfs2(root.right);
        target--;
        if (target == 0) res = root.val;
        dfs2(root.left);
    }

    /**
     * 以下这种做法时间复杂度太高了，毕竟要将树全都遍历
     */
    public List list = new ArrayList();
    public int kthLargest2(TreeNode root, int k) {
        dfs(root);
        int res = 0;
        Object[] nums = list.toArray();
        Arrays.sort(nums, 0 , nums.length);
        // for(int i = 0 ; i < nums.length  ; i++){
        //     System.out.print(nums[i] + " ");
        // }
        int idx = 0;
        for(int i = nums.length - 1 ;  i >=0 ; i--){
            res = (int) nums[i];
            idx++;
            if(idx == k)
                break;
        }
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null)
            return;
        else{
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }
    }
}
