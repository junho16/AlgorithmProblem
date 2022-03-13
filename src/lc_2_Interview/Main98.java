package lc_2_Interview;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Main98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        else
            return dfs(root)[0] == 1;
    }
    int[] dfs(TreeNode root){
        // 第一位：是否有问题 第二位：包括根节点在内的树的最大值 3位是最小值
        int[] res = new int[]{1 , root.val , root.val};
        if(root.left != null){
            int[] resL = dfs(root.left);
            if(resL[0] == 0 || resL[1] >= root.val)
                res[0] = 0;
            res[1] = Math.max(res[1] , resL[1]);
            res[2] = Math.min(res[2] , resL[2]);
        }
        if(root.right != null){
            int[] resR = dfs(root.right);
            if(resR[0] == 0 || resR[2] <= root.val)
                res[0] = 0;
            res[1] = Math.max(res[1] , resR[1]);
            res[2] = Math.min(res[2] , resR[2]);
        }
        return res;
    }
//    中序遍历看是否递增就不说了
//    下面的做法明显是错误的 ，因为会出现 某一个子树（假设是右子树）中 存在一个比 某一个根更小的值
//    public boolean isValidBST(TreeNode root) {
//        if(root == null)
//            return true;
//        boolean left = true;
//        boolean right = true;
//        if(root.left != null)
//            left = root.left.val < root.val;
//        if(root.right != null)
//            right = root.right.val > root.val;
//        return left && right && isValidBST(root.left) && isValidBST(root.right));
//    }
}
