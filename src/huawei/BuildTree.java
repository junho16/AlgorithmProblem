package huawei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Junho
 * @date 2022/5/10 21:22
 */
public class BuildTree {
    /**
     * 给出一行值 # 作为null， 输出二叉树 层序遍历
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] strings = s.split(",");
        Node root = new Node(strings[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int idx = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size ; i++){
                Node node = queue.poll();

                idx++;
                if(idx < strings.length && strings[idx].equals('#')){
                    node.left = null;
                }else if(idx < strings.length && !strings[idx].equals('#')){
                    node.left = new Node(strings[idx]);
                    queue.add(node.left);
                }

                idx++;
                if(idx < strings.length && strings[idx].equals('#')){
                    node.right = null;
                }else if(idx < strings.length && !strings[idx].equals('#')){
                    node.right = new Node(strings[idx]);
                    queue.add(node.right);
                }
            }
        }
        printNode(root);
    }
    static void printNode(Node root){
        Queue<Node> queue = new LinkedList<>();


        queue.add(root);
        int size = 1;
        while (!queue.isEmpty()){
            int num = 0 ;
            ArrayList<String> list = new ArrayList();
            for(int i = 0 ; i < size ;i++){
                Node peeknode = queue.poll();
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
            for(String s: list){
                System.out.print(s + " ");
            }
            System.out.println();
            size = num;
        }
    }
}
class Node{
    String val;
    Node left;
    Node right;
    public Node(String val){
        this.val = val;
    }
}