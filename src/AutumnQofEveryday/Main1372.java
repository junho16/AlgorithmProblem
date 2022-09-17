package AutumnQofEveryday;

/**
 * 1372. 二叉树中的最长交错路径
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 *
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 *
 * 请你返回给定树中最长 交错路径 的长度。
 */
public class Main1372 {
    static int res = 0;
    //这种方式 ==》递归的时候返回左右子树遍历出的最大长度（可走的最长距离）同时使用静态变量判断是否有最优值出现 有则更新
    public int longestZigZag(TreeNode root) {
        dfs(root , 0);
        int ress = res;
        res = 0;
        return ress;
    }
    int dfs(TreeNode root , int fx){
        if(root == null)
            return 0;
        int left = dfs(root.left , 0);
        int right = dfs(root.right , 1);
        res = Math.max(res ,  Math.max(left , right));
        if(fx == 0){
            return right + 1;
        }else{
            return left + 1;
        }
    }
//    TTL 已超时 50000的数据范围 应该将时间复杂度控制在nlogn
//    static int res = 0 ;
//    public int longestZigZag(TreeNode root) {
//        dfs(root);
//        int ress = res;
//        res = 0;
//        return ress;
//    }
//    void dfs(TreeNode root){
//        if(root == null){
//            return;
//        }
//
//        dfs(root.left);
//        getRes(root , 0 ,0);
//        getRes(root , 1 ,0);
//        dfs(root.right);
//    }
//    //fx为父节点的左右节点方向
//    void getRes(TreeNode root , int fx , int val){
//        if(root == null)
//            return;
//        //0 left    1 right
//        if((fx == 0 && root.right == null) ||( fx == 1 && root.left ==null)){
//            res = Math.max(res , val);
//            return;
//        }
//        if(fx == 0 && root.right != null){
//            getRes( root.right , 1 , val + 1);
//        }else if(fx == 1 && root.left !=null){
//            getRes( root.left  , 0 , val + 1);
//        }
//    }
}
