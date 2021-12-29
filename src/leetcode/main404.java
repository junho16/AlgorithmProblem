package leetcode;

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 */
public class main404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left != null && root.left.left != null && root.right.right != null){
            return root.left.val;
        }else{
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}
