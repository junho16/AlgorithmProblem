package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Main7 {
    //存储数据和其下标（通过终须有遍历的数组）
    public Map<Integer , Integer> map = new HashMap<>();

    public int[] preOrder;
    public int[] inOrder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inOrder = inorder;
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i] , i);
        }
        return dfs(0, 0 , preorder.length - 1 );
    }

    //需要记录一下目前需要使用的前序遍历的第一个数的位置（目的是为了找到根的位置）
    public TreeNode dfs(int rootidx , int str , int end ){
        if(str > end)
            return null;
        int x = preOrder[rootidx];
        int idx = map.get(x);
        TreeNode root = new TreeNode(x);
        root.left = dfs(rootidx +1 , str , idx-1 );
        root.right = dfs(rootidx + (idx - str + 1) , idx+1 , end);
        return root;
    }
}
