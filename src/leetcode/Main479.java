package leetcode;

/**
 * 479. 最大回文数乘积
 *  给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
 *
 * @author Junho
 * @date 2022/4/16 10:56
 */
public class Main479 {
    public int largestPalindrome(int n) {
        if(n == 1)
            return 9;
        long max = (long) (Math.pow(10 , n) - 1);
        for(long i = max ; i >= 0 ; i--){
            String x = i + "";
            String y = new StringBuilder(x).reverse().toString();
            Long num = Long.parseLong(x + y);
            for(long j = max ; j * j >= num ; j-- ){
                if(num % j == 0){
                    return (int) (num % 1337);
                }
            }
        }
        return 0;
    }
}