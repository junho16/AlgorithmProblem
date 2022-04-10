package weekGame.week_4_10;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 6039. K 次增加后的最大乘积 显示英文描述
 * 通过的用户数2442
 * 尝试过的用户数3713
 * 用户总通过次数2476
 * 用户总提交次数9024
 * 题目难度Medium
 * 给你一个非负整数数组 nums 和一个整数 k 。每次操作，你可以选择 nums 中 任一 元素并将它 增加 1 。
 *
 * 请你返回 至多 k 次操作后，能得到的 nums的 最大乘积 。由于答案可能很大，请你将答案对 109 + 7 取余后返回
 *
 * @author Junho
 * @date 2022/4/10 12:03
 */
public class Main6039 {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for(int i =0 ; i < nums.length ;i++){
            queue.add(nums[i]);
        }
        while (k != 0 ){
            k --;
            queue.add(queue.poll() + 1);
        }
        long sum = 1;
        while (! queue.isEmpty()){
            sum *= queue.poll();
            sum %= 1e9+7;
        }
        return (int)sum;
    }

//    暴力DFS超时了
//    int k;
//    int[] nums;
//    int res = 0;
//    public int maximumProduct(int[] numss, int kk) {
//        k = kk;
//        nums = numss;
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0 ; i < numss.length ; i++){
//            list.add(numss[i]);
//        }
//        dfs(list ,0 , k);
//        return res;
//    }
//    //第几位 剩余k数量
//    void dfs(List<Integer> keys , int idx , int u){
//        if(u == 0 || idx == nums.length){
//            int sum = 1;
//            for(int i = 0 ;i < keys.size() ;i++){
//                sum *= keys.get(i);
//                sum %= 1e9+7;
//            }
//            res = Math.max(res , sum);
//            return;
//        }
//        List<Integer> listTmp = new ArrayList<>(keys);
//        int org =  listTmp.get(idx);
//        for(int i = 0 ;i <= u ; i++ ){
//
//            listTmp.set(idx , org + i);
//            dfs(new ArrayList<>(listTmp) , idx + 1 , u-i);
//        }
//    }
}
