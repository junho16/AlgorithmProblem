package interview.lc_2_Interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class Main113 {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int t) {
        target = t;
        path = new LinkedList();
        res = new ArrayList<>();
        if(root == null)
            return res;
        dfs(root , 0);
        return res;
    }
    void dfs(TreeNode root , int sum){
        path.add(root.val);
        if(root.left == null && root.right == null && sum + root.val == target){
            res.add(new ArrayList<>(path));
            return;
        }
        if(root.left != null){
            dfs(root.left , sum + root.val);
            path.removeLast();
        }
        if(root.right != null){
            dfs(root.right , sum + root.val);
            path.removeLast();
        }
    }
//    下面的代码没有优化 时间复杂度过高 因为要处理字符串
//    List<List<Integer>> res;
//    int target;
//    public List<List<Integer>> pathSum(TreeNode root, int t) {
//        target = t;
//        res = new ArrayList<>();
//        dfs(root , 0 , "");
//        return res;
//    }
//    void dfs(TreeNode root , int sum , String path){
//        if(root == null)
//            return;
//        path += (" " + root.val);
//        if(root.left == null && root.right == null && sum + root.val == target){
//            List<Integer> resTmp = new ArrayList<>();
//            String[] strs = path.split(" ");
//            for(int i = 0 ; i < strs.length ;i++){
//                if(! strs[i].equals(""))
//                    resTmp.add(Integer.parseInt(strs[i]));
////                System.out.println(strs[i]);
//            }
//            res.add(resTmp);
//        }
//        dfs(root.left , sum + root.val , path);
//        dfs(root.right , sum + root.val , path);
//
//    }
}
