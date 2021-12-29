package offer;

/**
 *
 * 剑指offer26 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class Main26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //有一个空说明 不能匹配 因为空节点不算子结构
        if(A == null || B == null)
            return false;

        //两个都不空则判断当前 判断左右里有没有
        return dfs(A,B) || isSubStructure(A.left , B) || isSubStructure(A.right , B);
    }
    boolean dfs(TreeNode A, TreeNode B){
        //b空就无了 b不空且a空或者值不等 也无了
        //否则就直接对比左右子树 注意，这里需要使用&&
        if(B == null)
            return true;
        if(A != null && A.val == B.val){
            return dfs(A.left ,B.left) && dfs(A.right , B.right);
        }else{
            return false;
        }

    }
}
