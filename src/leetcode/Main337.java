package leetcode;

/**
 * 可能是最简单的树形dp
 *
 * 337. 打家劫舍 III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 *
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 *
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 * @author Junho
 * @date 2022/4/16 18:11
 */
public class Main337 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0] , res[1]);
    }
    int[] dfs(TreeNode root){
        int[] res = new int[2];
        if(root == null){
            return res;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = Math.max(left[0] , left[1]) + Math.max(right[0] , right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }

}
