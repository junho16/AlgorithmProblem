package offer;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */
public class Main16 {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        //正确处理负数的方式 如果你直接取abs则会爆int
        //可以看题解链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
//        boolean flag_x = false;
//        boolean flag_n = false;
//        if(x < 0)
//            flag_x = true;
//        if(n < 0)
//            flag_n = true;
//        x = Math.abs(x);
//        n = Math.abs(n);
//        int nn = n;
//        double res = 1;
//        while (n != 0){
//            if((n & 1) != 0){
//                res = res * x % Integer.MAX_VALUE;
//            }
//            x = x * x;
//            n >>= 1;
//        }
//        System.out.println(res);
//        if(!flag_x){
//            //x为正数
//            System.out.println("0");
//            return flag_n ? 1/res:res;
//        }else{
//            //x为负
//            return flag_n ? (( n % 2 == 0)? 1/res : (1/res)*-1 ):(( n % 2 == 0)?res:res*-1);
//
//        }

