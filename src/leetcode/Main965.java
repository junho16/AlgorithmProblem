package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 * @author Junho
 * @date 2022/5/26 20:27
 */
public class Main965 {
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.val != val)
                return false;
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return true;
    }
}
