package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 */
public class Main513 {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode res = new TreeNode();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int size = 0 ;
        while (!queue.isEmpty()){
            int num = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == 0)
                    res = node;
                if(node.left != null ){
                    num ++;
                    queue.add(node.left);
                }

                if(node.right != null){
                    num ++;
                    queue.add(node.right);
                }
            }
            size = num;
        }
        return res.val;
//        TreeNode res = new TreeNode();
//        Queue<TreeNode> queue = new LinkedList();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            for(int i = 0; i < queue.size(); i++){
//                TreeNode node = queue.poll();
//                if(i == 0)
//                    res = node;
//                if(node.left != null )
//                    queue.add(node.left);
//                if(node.right != null)
//                    queue.add(node.right);
//            }
//        }
//        return res.val;
    }
}
