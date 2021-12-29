package leetcode;

import com.sun.deploy.panel.ITreeNode;

/**
 * 222. 完全二叉树的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 */
public class Main222 {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int x = 1;
        int y = 1;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while(left != null){
            left = left.left;
            x ++;
        }
        while(right != null){
            right = right.right;
            y ++;
        }
        if(x == y)
            return (int) (Math.pow(2 , x) -1);
        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    /**
     * 但是下面这种做法又没有使用到完全二叉树的定义 ，因此需要一种O（logN * logN）时间复杂度的做如第二种所示：两个字 妙啊
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }


}
