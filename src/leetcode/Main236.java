package leetcode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Main236 {

    /**
     * 自己的代码-第二次写的如下：
     */
    public TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root , p ,q);
        return res;
    }
    public int dfs(TreeNode root , TreeNode p , TreeNode q){
        if(root == null){
            return 0;
        }
        int num = 0;
        if(root == p)
            num += 1;
        if(root == q)
            num += 2;
        if(root.left != null){
            num += dfs(root.left  ,p , q);
        }
        if(root.right != null){
            num += dfs(root.right  ,p , q);
        }
        if(num == 3 && res == null ){
            res = root;
        }
        return num;
    }
    /**
     * 以下是第一次提交的代码， yxc亲传
     *  public TreeNode res = null;
     *     public TreeNode p;
     *     public TreeNode q;
     *
     *     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode pp, TreeNode qq) {
     *         p = pp;
     *         q = qq;
     *         dfs(root);
     *         return res;
     *     }
     *     int dfs(TreeNode root){
     *         if(root == null)
     *             return 0;
     * //        if(root == p || root == q)
     * //            return 1;
     *         int status = 0;
     *         status += dfs(root.left);
     *         status += dfs(root.right);
     *         if(root == p || root ==q)
     *             status+=1;
     *         if(status == 2 && res ==null){
     *             res = root;
     *         }
     *
     *         return status;
     *     }
     */

}