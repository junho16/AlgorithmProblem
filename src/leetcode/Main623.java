package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 623. 在二叉树中增加一行
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
 *
 * 注意，根节点 root 位于深度 1 。
 *
 * 加法规则如下:
 *
 * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 *
 * @author Junho
 * @date 2022/8/5 15:45
 */
public class Main623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return new TreeNode(val);
        }
        queue.add(root);
        if(depth == 1){
            TreeNode left = new TreeNode(val);
            left.left = root;
            return left;
        }
        int level = 1;
        while( !queue.isEmpty()){
            level++;
            if(level == depth){
                while (!queue.isEmpty()){
                    TreeNode node = queue.poll();
                    TreeNode left = new TreeNode(val);
                    TreeNode right = new TreeNode(val);
                    left.left = node.left;
                    right.right = node.right;
                    node.left = left;
                    node.right = right;
                }
                return root;
            }
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

        }
        return null;
    }
}
