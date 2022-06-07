package interview.lc_2_Interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class Main102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList arr;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int size = 1;
        while (! queue.isEmpty()){
            int num = 0;
            arr = new ArrayList();
            for(int i = 0 ; i < size ; i++ ){
                TreeNode node = queue.poll();
                arr.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                    num++;
                }
                if(node.right != null){
                    queue.add(node.right);
                    num++;
                }
            }
            size = num;
            res.add(arr);
        }
        return res;
    }
}
