package offer;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class Main33 {
    public int[] post;
    public boolean verifyPostorder(int[] postorder) {
        post = postorder;
        return dfs(0 , postorder.length - 1 );
    }
    public boolean dfs(int l  ,int r ){
        if(l > r )
            return true;
        int root = post[r];

        int idx = l;
        while (idx < r && post[idx] < root){
            idx++;
        }
        for(int i = idx ; i < r ; i++){
            if(post[i] < root){
                return false;
            }
        }
        return dfs(l , idx - 1) && dfs(idx , r-1);
    }
}
