package leetcode;

import java.util.*;

/**
 * 662. 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * @author Junho
 * @date 2022/4/10 21:28
 */
public class Main662 {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (! queue.isEmpty()){
            res = Math.max(res , queue.peekLast().val - queue.peekFirst().val + 1 );
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    node.left.val = node.val * 2 - 1;
                    queue.add(node.left);
                }
                if(node.right != null){
                    node.right.val = node.val * 2;
                    queue.add(node.right);
                }
            }
        }
        return res;

    }
}