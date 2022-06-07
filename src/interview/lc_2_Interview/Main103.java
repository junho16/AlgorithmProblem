package interview.lc_2_Interview;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Main103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean front = true;
        int size = 1;
        while (! queue.isEmpty()){
            int num = 0;
            List<Integer> listtmp = new ArrayList();
            for(int i = 0 ; i < size ;i++){
                TreeNode node = queue.poll();
                listtmp.add(node.val);
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
            if(!front){
                Collections.reverse(listtmp);
                res.add(listtmp);
            }else{
                res.add(listtmp);
            }
            front = !front;
        }
        return res;
    }
}
