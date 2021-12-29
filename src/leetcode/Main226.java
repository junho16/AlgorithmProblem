package leetcode;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 */
public class Main226 {
    public TreeNode invertTree(TreeNode root) {
        // if(root.left == null && root.right == null)
        //     return null;
        if(root == null )
            return null;
        if(root.left != null)
            invertTree(root.left);
        if(root.right != null)
            invertTree(root.right);
        TreeNode l_tmp = root.left;
        TreeNode r_tmp = root.right;
        root.left = r_tmp;
        root.right = l_tmp;
        return root;
    }
}
