package lc_2_Interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @author Junho
 * @date 2022/3/20 21:07
 */
public class Main199 {
    public List<Integer> rightSideView(TreeNode root) {
        List list = new ArrayList();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int size = 1;
        while (!queue.isEmpty()){
            int num = 0;
            for(int i = 0; i < size  ; i++ ){
                TreeNode node = queue.poll();
                if(i == size - 1)
                    list.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                    num++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    num++;
                }
            }
            size = num;
        }
        return list;
    }
}
