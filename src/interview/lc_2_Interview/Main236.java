package interview.lc_2_Interview;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Main236 {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root , p , q);
        return res;
    }
    public int dfs(TreeNode root , TreeNode p , TreeNode q){
        int num = 0;
        if(root == null ){
            return num;
        }
        if(root == p){
            num += 1;
        }
        if(root == q){
            num += 2;
        }
        if(root.left != null){
            num += dfs(root.left , p , q);
        }
        if(root.right != null){
            num += dfs(root.right , p , q);
        }
        if(num == 3 && res == null){
            res = root;
        }
        return num;
    }
}
