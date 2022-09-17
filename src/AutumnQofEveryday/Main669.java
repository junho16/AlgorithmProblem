package AutumnQofEveryday;

/**
 * @author Junho
 * @date 2022/9/17 10:01
 */
public class Main669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)
            return null;
        TreeNode left = trimBST(root.left , low , high);
        TreeNode right = trimBST(root.right , low , high);

        // 此节点不需要删除
        root.left = left;
        root.right = right;

        if(root.val <= low && root.val >= high){
            // 此节点需要删除
            if(left == null && right == null){
                return null;
            }else if(left != null && right != null){
                // 将右子树最小值放过来
                TreeNode cur = right;
                TreeNode pre = root;
                while (cur.left != null){
                    pre = cur;
                    cur = cur.left;
                }
                root.val = cur.val;
                if(pre == root)
                    pre.right = null;
                else
                    pre.left = null;
                return root;
            }else{
                return left == null ? right : left;
            }
        }
        return root;
    }
}
