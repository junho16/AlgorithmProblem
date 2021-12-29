package leetcode;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 687. 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 */
public class Main687 {
    public int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int x = dfs(root.left);
        int y = dfs(root.right);
        int num = 0;
        if(root.left != null && root.val != root.left.val){
            x = 0;
        }
        if(root.right != null && root.val != root.right.val){
            y = 0;
        }
        res = Math.max(res , x + y);
        return Math.max(x, y) + 1;
    }
}
