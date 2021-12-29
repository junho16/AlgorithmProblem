package offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class Main34 {
    public List<Integer> path;
    public List<List<Integer>> res;
    public int target;
    public List<List<Integer>> pathSum(TreeNode root, int t) {
        target = t;
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(root , 0);
        return res;
    }
    void dfs(TreeNode root , int val){
        if(root == null)
            return;
        val += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(target == val){
                ArrayList tmp = new ArrayList(path);
                res.add(tmp);
            }
//            else{
//                path.remove(path.size()-1);
//            }
            return;
        }
        if(root.left != null){
            dfs(root.left , val);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            dfs(root.right , val);
            path.remove(path.size()-1);
        }
    }
}
