package leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * @author Junho
 * @date 2022/5/30 16:38
 */
public class Main437 {
    int res;
    int target;
    // 记录下从某一个节点开始的哪些 如果已经出现 则不会从此节点再开始
    Set<TreeNode> set = new HashSet<>();
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        target = targetSum;
        set.add(root);
        dfs(root , root.val);
        return res;
    }
    void dfs(TreeNode root , int sum){
        if(sum == target){
            res++;
        }
        if(root.left != null){
            if(!set.contains(root.left)){
                set.add(root.left);
                dfs(root.left , root.left.val  );
            }
            dfs(root.left , sum + root.left.val );
        }
        if(root.right != null){
            if(!set.contains(root.right)){
                set.add(root.right);
                dfs(root.right , root.right.val );
            }
            dfs(root.right , sum + root.right.val );
        }
    }
}
