package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 * @author Junho
 * @date 2022/5/11 13:27
 */
public class Main449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        if(root == null)
            return "#";
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (! queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                res += "#,";
            }else{
                res += node.val+",";
                queue.add(node.left);
                queue.add(node.right);
            }

        }
//        System.out.println(res);
        return res.substring(0,res.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        if(strings.length == 0 || strings[0].equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        int idx = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(! queue.isEmpty()){
            TreeNode node = queue.poll();
            if(idx < strings.length){
                node.left = strings[idx].equals("#") ? null : new TreeNode(Integer.parseInt(strings[idx]));
                idx++;
                if(node.left != null)
                    queue.add(node.left);
            }
            if(idx < strings.length){
                node.right = strings[idx].equals("#") ? null : new TreeNode(Integer.parseInt(strings[idx]));
                idx++;
                if(node.right != null)
                    queue.add(node.right);
            }
        }
        return root;
    }

    void printNode(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        while (!queue.isEmpty()){
            int num = 0 ;
            ArrayList<Integer> list = new ArrayList();
            for(int i = 0 ; i < size ;i++){
                TreeNode peeknode = queue.poll();
                if(peeknode != null){
                    list.add(peeknode.val);
                    if(peeknode.left!=null) {
                        queue.add(peeknode.left);
                        num++;
                    }
                    if(peeknode.right!=null) {
                        queue.add(peeknode.right);
                        num++;
                    }
                }

            }
            for(Integer s: list){
                System.out.print(s + " ");
            }
            System.out.println();
            size = num;
        }
    }
}
