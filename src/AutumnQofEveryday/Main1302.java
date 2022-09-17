package AutumnQofEveryday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 *
 * @author Junho
 * @date 2022/9/12 15:54
 */
public class Main1302 {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            list = new ArrayList<>();
            for(int i = 0 ; i < size ;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        int res = 0;
        for(int i = 0 ; i < list.size() ;i++){
            res += list.get(i);
        }
        return res;
    }
}
