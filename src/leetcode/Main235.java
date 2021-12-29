package leetcode;

import com.sun.org.apache.xml.internal.utils.res.XResources_zh_CN;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 */
public class Main235 {
    public TreeNode res;
    public TreeNode p;
    public TreeNode q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode pp, TreeNode qq) {
        res = null;
        p = pp;
        q = qq;
        dfs(root);
        return res;
    }

    /**
     * 实际上的正解思路我没写出来，其实应该是判断是否在同一侧，如果不在同一侧，则当前节点就是结果，如果在同一侧，则dfs那个分支
     * 所以时间复杂度是O（h）
     * @param root
     * @return
     */
    public int dfs(TreeNode root){
        if (root == null)
            return 0;
        int num = 0;
        if(root == p)
            num += 1;
        if(root == q)
            num += 2;

        if(root.val < p.val && root.val < q.val){
            num += dfs(root.right);
        }else if(root.val > p.val && root.val > q.val){
            num += dfs(root.left);
        }else{
            num += root.left == null ? 0:dfs(root.left);
            num += root.right == null ? 0:dfs(root.right);
        }
        if(num == 3 && res == null){
            res = root;
        }
        return num;
    }
}
