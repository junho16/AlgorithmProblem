package interview.lc_2_Interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class Main105 {

    Map<Integer , Integer> map;
    int[] pre;
    int[] ino;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        ino = inorder;

        map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i] , i);
        }
        return dfs(0 , preorder.length -1 , 0 , inorder.length - 1 );
    }
    TreeNode dfs(int preStart , int preEnd , int inoStart , int inoEnd){
        if(preStart > preEnd || inoStart > inoEnd)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);


        root.left = dfs(
                preStart + 1 ,
                preStart + map.get(pre[preStart]) - inoStart ,
                inoStart ,
                map.get(pre[preStart]) - 1);

        root.right = dfs(
                preStart + map.get(pre[preStart]) - inoStart + 1,
                preEnd,
                map.get(pre[preStart]) + 1 ,
                inoEnd
        );
        return root;
    }

}
