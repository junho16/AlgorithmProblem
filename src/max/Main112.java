package max;
/**
112. 路径总和
给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。

叶子节点 是指没有子节点的节点。
 */
public class Main112 {
    public boolean res = false;
    public int targetSum;
    public boolean hasPathSum(TreeNode root, int ts) {
        targetSum = ts;
        dfs(root,0);
        return res;
    }
    public void dfs(TreeNode root , int num){
        if(root == null)
            return ;
        if(root.left == null && root.right == null && targetSum == num + root.val ){
            res = true;
        }
        dfs(root.left , num + root.val);
        dfs(root.right , num + root.val);
    }
}
