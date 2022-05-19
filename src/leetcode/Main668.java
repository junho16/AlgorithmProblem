package leetcode;

/**
 * 668. 乘法表中第k小的数
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 *
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 *
 * @author Junho
 * @date 2022/5/18 22:34
 */
public class Main668 {
    public int findKthNumber(int m, int n, int k) {
        int left = 0 ,right = m*n;
        while (left < right){
            int mid = left + right >> 1;
            if(getCount(n , m , mid) >= k ){
                right = mid;
            }else{
                left = mid - 1;
            }
        }
        return right;
    }
    int getCount(int n , int m , int mid){
        int res = 0;
        for(int i = 1 ; i <= n ;i++){
            res += Math.min(m , mid / i);
        }
        return res;
    }
}
