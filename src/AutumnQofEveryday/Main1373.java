package AutumnQofEveryday;

/**
 * 1373. 二叉搜索子树的最大键值和
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 * 二叉搜索树的定义如下：
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树
 * @author Junho
 * @date 2022/9/15 21:42
 */

class SumNode{
    int sum;
    int min;
    int max;
    public SumNode(int sum , int min , int max){
        this.sum = sum;
        this.min = min;
        this.max = max;
    }
}
public class Main1373 {

    static int resnum = Integer.MIN_VALUE;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        int ress = resnum;
        resnum = 0;
        return ress;
    }
    // 总和 最小 最大值
    SumNode dfs(TreeNode root){

        // 假设左子树为空 则当前节点应该大于左子树最大值 因此最大设为-INF, 返回左子树最小值就应该是当前节点的值
        SumNode left = new SumNode(0 , root.val , Integer.MIN_VALUE);
        SumNode right = new SumNode(0 , Integer.MAX_VALUE , root.val);

        if(root.left != null)
            left = dfs(root.left);

        if(root.right != null)
            right = dfs(root.right);

        if(root.val < right.min && root.val > left.max) {
            int sum = root.val + left.sum + right.sum;
            resnum = Math.max(resnum, sum);
            return new SumNode(
                    sum, left.min, right.max
            );
        }
        //如果不是二叉搜索树 则应该返回不影响结果的答案
        return new SumNode(
                0, Integer.MIN_VALUE, Integer.MAX_VALUE
        );

//        if(left == null && right != null){
//            return new SumNode(
//                root.val + right.sum,
//                Math.min(root.val , right.min),
//                Math.max(root.val , right.max)
//            );
////            int[] res = {root.val + right[0] , Math.min(root.val , right[1]) , Math.max(root.val , right[2]) };
////            if(root.val < right[1])
////                resnum = Math.max(resnum , root.val + right[0]);
////            return res;
//        }else if(left != null && right == null){
//            return new SumNode(
//            root.val + left.sum,
//                Math.min(root.val , left.min),
//                Math.max(root.val , left.max)
//            );
////            int[] res = {root.val + left[0] , Math.min(root.val , left[1]) , Math.max(root.val , left[2]) };
////            if(root.val > left[2])
////                resnum = Math.max(resnum , root.val + left[0]);
////            return res;
//        }else {
//
//            if(root.val < right[1] && root.val > left[2]){
//                int[] res = {
//                        root.val + left[0] + right[0],
//                        Math.min(root.val , Math.min( left[1] , right[1])),
//                        Math.max(root.val , Math.min( left[2] , right[2]))
//                };
//                resnum = Math.max(resnum , root.val + left[0] + right[0]);
//                return res;
//            }else{
//                int[] res = {root.val , root.val , root.val};
//                return res;
//            }
//        }
    }
}
