package max;

import com.sun.deploy.panel.ITreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 */
public class Main103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        int size = queue.size();
        List<List<Integer>> res = new ArrayList<>();
        while(! queue.isEmpty()){
            int num = 0;
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left !=  null){
                    num++;
                    queue.add(node.left);
                }
                if(node.right != null){
                    num++;
                    queue.add(node.right);
                }
            }
            size = num;
            if(!flag){
                Collections.reverse(list);
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }
}
