package interview.lc_2_Interview;

/**
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 */
public class Main129 {
    int res;
    public int sumNumbers(TreeNode root) {
        res = 0;
        if(root == null)
            return 0;
        dfs(root ,  0 );
        return res;
    }
    void dfs(TreeNode root , int sum ){
        if(root.left == null && root.right ==null){
            res += sum;
            return ;
        }
        if(root.left != null)
            dfs(root.left , sum * 10 + root.left.val);
        if(root.right != null)
            dfs(root.right , sum * 10 + root.right.val);
    }
//    下面的解法是暴力，可以看下上面的解法
//    List<String> strs;
//    public int sumNumbers(TreeNode root) {
//        strs = new ArrayList<>();
//        if(root == null)
//            return 0;
//        dfs(root ,  "" );
//        int res = 0;
//        for(String s : strs){
//            res += Integer.parseInt(s);
//        }
//        return res;
//    }
//    void dfs(TreeNode root , String path ){
//        if(root.left == null && root.right ==null){
//            strs.add(path + root.val);
//            return;
//        }
//        if(root.left != null)    dfs(root.left , path + root.val);
//        if(root.right != null)    dfs(root.right , path + root.val);
//    }
}
