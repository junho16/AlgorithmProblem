package leetcode;

import java.util.*;

/**
 * 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * @author Junho
 * @date 2022/6/20 9:47
 */
public class Main508 {
    Map<Integer , Integer> map = new TreeMap();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Map.Entry<Integer , Integer>> list = new ArrayList<Map.Entry<Integer , Integer>>(map.entrySet());

        Collections.sort(list , new Comparator<Map.Entry<Integer , Integer>>() {
            @Override
            public int compare(Map.Entry<Integer , Integer> o1, Map.Entry<Integer , Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<Integer> resList = new ArrayList<>();
        if(list.size() != 0){
            int num = (int) list.get(0).getValue();
            for(int i = 0 ; i < list.size() ; i++){
                if( (int)list.get(i).getValue() == num ){
                    resList.add( (int)list.get(i).getKey());
                }
            }
        }
//        for(Map.Entry entry : map.entrySet()){
//            System.out.println(entry.getKey() +" " + entry.getValue());
//        }
        int[] res = new int[resList.size()];
        int idx = 0;
        for(Integer i : resList){
            res[idx++] = i;
        }
        return res;
    }
    void dfs(TreeNode node){
        if(node == null){
            return;
        }
        int val = getSum(node);
        map.put(val , map.getOrDefault(val , 0) + 1);
        dfs(node.left);
        dfs(node.right);
    }
    int getSum(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.val + getSum(root.left) + getSum(root.right);
    }
}