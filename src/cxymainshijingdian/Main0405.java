package cxymainshijingdian;
/**
 * 面试题 04.05. 合法二叉搜索树
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 */
public class Main0405 {
    public long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        boolean a = isValidBST(root.left);
        if (pre >= root.val)
            return false;
        else
            pre = root.val;
        boolean b = isValidBST(root.right);
        return a && b;

    }
}

//        if(root == null)
//            return true;
//        if(root.left != null && root.left.val >= root.val)
//            return false;
//        if(root.right != null && root.right.val <= root.val)
//            return false;
//        boolean leftBool = true;
//        boolean rightBool = true;
//        if(root.left != null){
//            leftBool = isValidBST(root.left);
//        }
//        if(root.right != null){
//            rightBool = isValidBST(root.right);
//        }
//        return  leftBool && rightBool;

