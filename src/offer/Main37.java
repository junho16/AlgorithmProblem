package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * @author Junho
 * @date 2022/4/11 16:21
 */
public class Main37 {
    Queue<Integer> queue = new LinkedList<>();
    String str = "";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfsSer(root);
        return str;
    }
    void dfsSer(TreeNode root){
        if(root == null){
            str += "#";
            queue.add(null);
        }else{
            str += root.val;
            queue.add(root.val);
            dfsSer(root.left);
            dfsSer(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
//        TreeNode node = new TreeNode(queue.poll());
//        dfsdeSer(node);
        return dfsdeSer();
    }
    TreeNode dfsdeSer(){
        Integer nodeVal = queue.poll();
        if(nodeVal == null){
            return null;
        }else{
            TreeNode root = new TreeNode(nodeVal);
            root.left = dfsdeSer();
            root.right = dfsdeSer();
            return root;
        }
    }
}
