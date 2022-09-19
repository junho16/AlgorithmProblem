package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 * 给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
 * 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
 * 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。
 * @author Junho
 * @date 2022/9/18 20:28
 */
public class Main652 {
    List<TreeNode> resList;
    Map<String , Integer>  map;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        resList = new ArrayList<>();
        dfs(root);
        return resList;
    }
    public String dfs(TreeNode root){
        if(root == null)
            return " ";
        String left = dfs(root.left);
        String right = dfs(root.right);
        String str =  left + "_" + root.val + "_" + right;
        map.put(str , map.getOrDefault(str , 0) + 1);
        if(map.get(str) == 2){
            resList.add(root);
        }
        return str;
    }
}
