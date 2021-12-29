package leetcode;

/**
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 */
public class Main654 {

    static int[] nums;
    public TreeNode constructMaximumBinaryTree(int[] n) {
        nums = n;
        return dfs(0 , n.length - 1);
    }
    public TreeNode dfs(int left  , int right){
        if(left > right)
            return null;
        int maxidx = 0 , maxnum = Integer.MIN_VALUE;
        for(int i = left ; i <= right ;i++){
            if(nums[i] > maxnum){
                maxnum = nums[i];
                maxidx = i;
            }
        }
        TreeNode root = new TreeNode(maxnum);
        root.left = dfs(left , maxidx - 1 );
        root.right = dfs(maxidx + 1 , right);
        return root;
    }

}
