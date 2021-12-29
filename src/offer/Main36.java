package offer;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class Main36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    public Node preNode = null;
    public Node res = null;
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        dfs(root );
        res.left = preNode;
        preNode.right = res;

        return res;
    }
    void dfs(Node curRoot){
        if(curRoot == null)
            return;
        dfs(curRoot.left );

        curRoot.left = preNode;
        if(preNode != null)
            preNode.right = curRoot;
        else{
            res = curRoot;
        }
        preNode = curRoot;
        dfs(curRoot.right );
    }
}

