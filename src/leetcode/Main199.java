package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class Main199 {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null)queue.add(node.left);
                if(node.right != null)queue.add(node.right);
                if(i+1 == size){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
