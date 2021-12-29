package leetcode;

import java.util.Map;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class Main543 {
    public int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDeepLength(root);
        return res - 1;
    }
    int getDeepLength(TreeNode root){
        if(root == null){
            return 0;
        }
        int x = getDeepLength(root.left);
        int y = getDeepLength(root.right);
        res = Math.max(res , x + y + 1);
        return Math.max(x,y)+1;
    }
}
