package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * @author Junho
 * @date 2022/5/3 20:27
 */
public class Main1305 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1);
        dfs(root2);
        Collections.sort(res);
        return res;
    }
    void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
