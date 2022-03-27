package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 *
 * @author Junho
 * @date 2022/3/21 16:27
 */
public class Main95 {
    List<TreeNode> res;
    int n;
    public List<TreeNode> generateTrees(int nn) {
        n = nn;
        res = new ArrayList<>();
        return dfs(0 , n - 1);
    }
    List<TreeNode> dfs(int left  , int right){
        List<TreeNode> res = new ArrayList<>();
        if(left > right){
            return res;
        }
        if(left == right){
            res.add(new TreeNode(left));
            return res;
        }
        for(int i = left + 1 ;i < right ; i++){
            List<TreeNode> leftTree = dfs(left , i - 1);
            List<TreeNode> rightTree = dfs(i + 1 , right);
            for(TreeNode leftRoot : leftTree){
                for(TreeNode rightRoot : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
