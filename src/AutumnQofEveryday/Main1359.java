package AutumnQofEveryday;

/**
 * 1359. 有效的快递序列数目
 * 给你 n 笔订单，每笔订单都需要快递服务。
 *
 * 请你统计所有有效的 收件/配送 序列的数目，确保第 i 个物品的配送服务 delivery(i) 总是在其收件服务 pickup(i) 之后。
 *
 * 由于答案可能很大，请返回答案对 10^9 + 7 取余的结果。
 *
 * 第一个点: 所有的排列一共有 (2n)! 种情况, 每一种物品配送服务在收件服务之前或之后是等价对称的。
 * 每一件物品都要把配送服务在收件服务之前的情况去掉, 也就是说在 (2n)!基础上除以 2
 * 所以按照排列组合, 所以总的情况数为 (2n)!/2^n
 *
 * @author Junho
 * @date 2022/9/15 11:37
 */
public class Main1359 {
    public int countOrders(int n) {
        int MOD = (int) (1e9+7);
        long res = 1;
        for(int i = 1 ;i <= n * 2 ;i++){
            if(i % 2 == 1){
                res = res * i % MOD;
            }else{
                res = i / 2 * res % MOD;
            }
        }
        return (int)res;
    }
}
