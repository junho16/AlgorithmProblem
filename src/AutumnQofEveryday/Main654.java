package AutumnQofEveryday;

import javax.swing.text.TabExpander;

/**
 * 654. 最大二叉树
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 *
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * @author Junho
 * @date 2022/9/12 13:38
 */
public class Main654 {
    public static void main(String[] args) {
        constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        int maxidx = 0;
        for(int i = 0 , maxValue = nums[0] ; i < nums.length ; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxidx = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxidx]);
        int[] leftArr = new int[maxidx];
        int[] rightArr = new int[nums.length - maxidx - 1];
        for(int i = 0 ; i < maxidx ; i++){
            leftArr[i] = nums[i];
        }
        for(int i = maxidx + 1 , idx = 0 ; i < nums.length ; i++){
            rightArr[idx++] = nums[i];
        }
        root.left = constructMaximumBinaryTree(leftArr);
        root.right = constructMaximumBinaryTree(rightArr);
        return root;
    }
}
