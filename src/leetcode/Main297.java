package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 */
public class Main297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res=new StringBuilder("");
        dfs1(root,res);
        String str=res.toString();
        return str;
    }
    public void dfs1(TreeNode root,StringBuilder res){
        if(root==null)
        {
            res.append("null,");
        }
        else{
            res.append(String.valueOf(root.val)+",");
            dfs1(root.left,res);
            dfs1(root.right,res);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)
            return null;
        String[] data_array=data.split(",");
        List<String> data_list=new LinkedList<String>(Arrays.asList(data_array));
        return dfs2(data_list);
    }
    public TreeNode dfs2(List<String> data_list){
        if(data_list.get(0).equals("null"))
        {
            data_list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(data_list.get(0)));
        data_list.remove(0);
        root.left = dfs2(data_list);
        root.right = dfs2(data_list);
        return root;
    }
//    public String str = "";
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        return dfs(root);
////        return str;
//    }
//    String dfs(TreeNode root){
//        String str = "";
//        if(root == null)
//            return  "#,";
//        str += root.val + ",";
//        str += dfs(root.left);
//        str += dfs(root.right);
//        return str;
//    }
////    void dfs(TreeNode root){
////        if(root == null)
////            str += "#";
////        str += root.val + ",";
////        dfs(root.left);
////        dfs(root.right);
////    }
//    // Decodes your encoded data to tree.
//    public int idx = 0;
//    public TreeNode deserialize(String s) {
//        String[] data = s.split(",");
//        // String[] d = new String[data.length+1];
//        // for(int i = 1 ; i < data.length ;i++ ){
//        //     d[i] = data[i-1];
//        // }
//
//        for(int i = 0 ; i < data.length ;i++ ){
//            System.out.print(data[i] +" ");
//        }
//        System.out.println();
//        return redfs(data,idx);
//        // return redfs(d,1);
//    }
//    public TreeNode redfs(String[] data, int index){
//        System.out.println(data[index]+" ");
//        if(data[idx].equals("#")){
//            idx += 1;
//            return null;
//        }
//        //如果不是空
//        TreeNode root = new TreeNode(Integer.parseInt(data[index]));
//        idx+=1
//        root.left = redfs(data , idx + 1);
//        idx+=1
//        root.right = redfs(data , idx + 2);
//        // root.left = redfs(data , index * 2);
//        // root.right = redfs(data , index * 2 +1);
//        return root;
//    }
}
