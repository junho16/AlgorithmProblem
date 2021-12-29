package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class Main257 {
    List<String> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null)
            return ;
        path.add(String.valueOf(root.val));
        if(root.left == null && root.right == null) {
            res.add(String.join("->", path));
        }
        dfs(root.left);
        dfs(root.right);
        path.removeLast();
    }
}
