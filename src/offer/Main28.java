package offer;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class Main28 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return dfs(root.left , root.right);
    }
    boolean dfs(TreeNode left , TreeNode right){
        if(left == null && right ==null)
            return true;
        if((left == null && right != null) || (left != null && right == null)){
            return false;
        }
        if(left.val == right.val){
            return dfs(left.left , right.right) && dfs(left.right , right.left);
        }else{
            return false;
        }
    }
}
