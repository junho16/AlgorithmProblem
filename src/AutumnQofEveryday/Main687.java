package AutumnQofEveryday;

/**
 * 687. 最长同值路径
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 * 两个节点之间的路径长度 由它们之间的边数表示。
 * @author Junho
 * @date 2022/9/17 16:42
 */
public class Main687 {
    public int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }
    int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        if(root.left != null && root.left.val != root.val){
            left = 0;
        }
        if(root.right != null && root.right.val != root.val){
            right = 0;
        }
        res = Math.max(res , left + right);
        return 1 + Math.max(left , right);
    }
}
