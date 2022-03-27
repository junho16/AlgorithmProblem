package leetcode;

import java.util.ArrayList;

/**
 * 99. 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 * @author Junho
 * @date 2022/3/23 22:53
 */
public class Main99 {
    ArrayList<TreeNode> list;
    public void recoverTree(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        for(int i = 0 ; i < list.size() ; i++){
            if(i + 1 < list.size() && list.get(i + 1).val < list.get(i).val){
                int k = i + 1;
                while ( k + 1 < list.size() && list.get(k).val < list.get(k + 1).val){
                    k++;
                }
                if(k == list.size() - 1){
                    TreeNode l = list.get(i);
                    TreeNode r = list.get(i + 1);
                    int tmp = l.val;
                    l.val = r.val;
                    r.val = tmp;
                }else{
                    TreeNode l = list.get(i);
                    TreeNode r = list.get(k + 1);
                    int tmp = l.val;
                    l.val = r.val;
                    r.val = tmp;
                }
            }
        }
    }
    void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
}
