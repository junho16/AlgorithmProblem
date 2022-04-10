package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 * @author Junho
 * @date 2022/4/9 9:52
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class Main429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        int size = 1;


        while (! queue.isEmpty()){
            int num = 0;
            List<Integer> res_n = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                Node n = queue.poll();
                res_n.add(n.val);
                for(Node ntmp : n.children){
                    queue.add(ntmp);
                    num++;
                }
            }
            res.add(res_n);
            size = num;
        }
        return res;
    }
}
