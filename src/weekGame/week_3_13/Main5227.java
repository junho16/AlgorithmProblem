package weekGame.week_3_13;

/**
 * 5227. K 次操作后最大化顶端元素
 * 给你一个下标从 0 开始的整数数组 nums ，它表示一个 栈 ，其中 nums[0] 是栈顶的元素。
 *
 * 每一次操作中，你可以执行以下操作 之一 ：
 *
 * 如果栈非空，那么 删除 栈顶端的元素。
 * 如果存在 1 个或者多个被删除的元素，你可以从它们中选择任何一个，添加 回栈顶，这个元素成为新的栈顶元素。
 * 同时给你一个整数 k ，它表示你总共需要执行操作的次数。
 *
 * 请你返回 恰好 执行 k 次操作以后，栈顶元素的 最大值 。如果执行完 k 次操作以后，栈一定为空，请你返回 -1 。
 */
public class Main5227 {
    public int maximumTop(int[] nums, int k) {
        if(nums.length == 1){
            return k % 2 == 0 ? nums[0]:-1;
        }
        int maxNum = Integer.MIN_VALUE;
        for(int i = 0 ;i < k - 1 && i < nums.length  ; i++){
            maxNum = Math.max(maxNum , nums[i]);
        }
        if(k >= nums.length){
            return maxNum;
        }else{
            return Math.max(maxNum , nums[k] );
        }
    }
}
