package lc_2_Interview;

/**
 * 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class Main124 {
    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        getRes(root);
        return res;
    }
    int getRes(TreeNode root){
        if(root == null)
            return 0;

        int left = getRes(root.left);
        int right = getRes(root.right);


        int setp = root.val + Math.max(left , 0) + Math.max(right , 0);

        res = Math.max(res , setp);

        return root.val + Math.max(Math.max(left , 0 )  , Math.max(right , 0 ) );
    }
//  上面下面两种方法均可
//    int res;
//    public int maxPathSum(TreeNode root) {
//        res = Integer.MIN_VALUE;
//        getRes(root);
//        return res;
//    }
//    int getRes(TreeNode root){
//        if(root == null)
//            return 0;
//        int num = 0;
//        int left = getRes(root.left);
//        int right = getRes(root.right);
//
//        //横着的
//        int setp1 = root.val + Math.max(left , 0) + Math.max(right , 0);
//        //算左边或者右边 加上父节点的
//        int setp2 = root.val + Math.max( 0 , Math.max(left , right));
//
//        res = Math.max(res , Math.max( setp1 , setp2));
//
//        return setp2;
//    }
}
