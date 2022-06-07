package leetcode;

/**
 * 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 */
public class Main450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val < key){
            root.right = deleteNode(root.right , key);
        } else if(root.val > key){
            root.left = deleteNode(root.left , key);
        } else{
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null && root.right != null){
                return root.right;
            }else if(root.right == null && root.left != null){
                return root.left;
            }else{
                TreeNode tmp = root.right;
                while (tmp.left != null){
                    tmp = tmp.left;
                }
//                root.val = tmp.val;
//                root.right = deleteNode(root.right , tmp.val);
                tmp.left = root.left;
                root = root.right;
            }
        }
        return root;
    }
    
    
//    原AC代码
//    public TreeNode deleteNode(TreeNode root, int key) {
//        if(root == null){
//            return null;
//        }
//        if(root.val < key){
//            root.right = deleteNode(root.right , key);
//        }else if(root.val > key){
//            root.left = deleteNode(root.left , key);
//        }else{
//            //说明已经找到了可以删除的节点
//            if(root.right == null){
//                return root.left;
//            }else if(root.left == null){
//                return root.right;
//            }else{
//                TreeNode tmp = root.right;
//                while(tmp.left != null){
//                    tmp = tmp.left;
//                }
////                System.out.println(tmp.val);
//                root.val = tmp.val;
//                root.right = deleteNode(root.right, tmp.val);
//            }
//        }
//        return root;
//    }
    
    
    
//    public TreeNode deleteNode(TreeNode root, int key) {
//        //先找到节点
//        TreeNode node = getNode(root , key);
//        if(node.right == null){
//            node = node.left;
//        }else{
//            //找到node节点的的右子树的最左边的节点然后返回
//            TreeNode tmpNode = getLeftNodeInLastLevel(node.right );
//            TreeNode newNode = new TreeNode(tmpNode.val);
//
//            newNode.left = node.left;
//            newNode.right = node.right;
//            node = newNode;
//
//            tmpNode = null;
//
//        }
//        return root;
//    }
//    public TreeNode getLeftNodeInLastLevel(TreeNode root){
//        while (root.left != null){
//            root = root.left;
//        }
//        return root;
////        if(root.left != null){
////            return getLeftNodeInLastLevel(root.left);
////        }
////        if(root.left == null && root.right == null)
////            return root;
////        if(root.right != null){
////            return getLeftNodeInLastLevel(root.right);
////        }
////        return null;
//    }
//    public TreeNode getNode(TreeNode root , int key){
//        if(root == null)
//            return null;
//        if(root.val == key){
//            return root;
//        }
//        if(root.left != null && root.val > key){
//            return getNode(root.left , key);
//        }
//        if(root.right != null && root.val < key){
//            return getNode(root.right , key);
//        }
//        return null;
//    }

    /**
     * @param {TreeNode} root
     * @param {number} key
     * @return {TreeNode}
     */
//    var deleteNode = function(root, key) {
//        // 非空判断
//        if (!root) return root;
//        let getMin = (node) => {
//            // BST 最左边的就是最小的
//            while (node.left) {
//                node = node.left;
//            }
//            return node;
//        };
//        if (root.val == key) {
//            // 这两个 if 把情况 1 和 2 都处理了
//            if (root.left == null) return root.right;
//            if (root.right == null) return root.left;
//            // 处理情况 3
//            let minNode = getMin(root.right);
//            root.val = minNode.val;
//            // 找到最小的顶替它之后还要删除这个最小的节点
//            root.right = deleteNode(root.right, minNode.val);
//        } else if (root.val < key) {
//            root.right = deleteNode(root.right, key);
//        } else {
//            root.left = deleteNode(root.left, key);
//        }
//        return root;
//    };
}
