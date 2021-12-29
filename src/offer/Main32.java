package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main32 {
    public int[] levelOrder_1(TreeNode root) {
        if(root == null){
            int[] res = new int[0];
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length ; i++ ){
            res[i] = list.get(i);
        }
        return res;

    }


    public List<List<Integer>> levelOrder_3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean flag = true;
        int size = 1;
        while (! queue.isEmpty()){
            int num = 0;
            List<TreeNode> list = new ArrayList();
            for(int i =0 ; i< size ;i++){
                TreeNode peekNode = queue.poll();
                list.add(peekNode);
                if(peekNode.left != null){
                    queue.add(peekNode.left);
                    num++;
                }
                if(peekNode.right != null){
                    queue.add(peekNode.right);
                    num++;
                }
            }
            size = num;
            if(! flag){
                List reverseList = new ArrayList();
                for(int i = list.size() - 1 ; i >= 0 ; i-- )
                    reverseList.add(list.get(i).val);
                res.add(reverseList);
            }else{
                List numList = new ArrayList();
                for(int i = 0 ; i < list.size() ; i++ )
                    numList.add(list.get(i).val);
                res.add(numList);
            }
            flag = !flag;
        }
        return res;
    }
}
