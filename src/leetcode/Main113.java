package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * @author Junho
 * @date 2022/5/11 18:05
 */
public class Main113 {
    List<List<Integer>> res;
    int tar;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        tar = targetSum;
        res = new ArrayList<>();
        if(root == null)
            return res;
        List<Integer> l = new ArrayList<>();
        dfs(root , 0 , "");
        return res;
    }
    void dfs(TreeNode node , int sum , String list){
        sum += node.val;
        list += (node.val+" ");
        if(node.left == null && node.right == null){
            if(sum == tar){
                String[] strings = list.split(" ");
                List<Integer> tmp = new ArrayList<>();
                for(String s : strings){
                    if(!"".equals(s)){
                        tmp.add(Integer.parseInt(s));
                    }
                }
                res.add(tmp);
            }
            return;
        }



        if(node.left != null)
            dfs(node.left , sum , list);
        if(node.right != null)
            dfs(node.right , sum , list);
    }
}
