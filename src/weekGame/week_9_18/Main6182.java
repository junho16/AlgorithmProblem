package weekGame.week_9_18;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 6182. 反转二叉树的奇数层
 * 给你一棵 完美 二叉树的根节点 root ，请你反转这棵树中每个 奇数 层的节点值。
 * 例如，假设第 3 层的节点值是 [2,1,3,4,7,11,29,18] ，那么反转后它应该变成 [18,29,11,7,4,3,1,2] 。
 * 反转后，返回树的根节点。
 * 完美 二叉树需满足：二叉树的所有父节点都有两个子节点，且所有叶子节点都在同一层。
 * 节点的 层数 等于该节点到根节点之间的边数。
 * @author Junho
 * @date 2022/9/18 10:45
 */
public class Main6182 {
    /*
        [2,3,5,34,21,13,8]
        [7,13,11]
        [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
     */
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList();
        queue.addLast(root);
        int level = 0;
        while (! queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> nodeList = new ArrayList<>();
            List<Integer> valList = new ArrayList<>();
            for(int i = 0 ;i < size ; i++){
                TreeNode node = queue.poll();
                nodeList.add(node);
                valList.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(level % 2 == 1){
                for(int i = valList.size() - 1 , j = 0 ; i >= 0 ; i-- , j++){
                    nodeList.get(j).val = valList.get(i);
                }
            }
            level++;
        }
        return root;
    }
}
