package interview.lc_2_Interview;

/**
 * 69. x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class Main69 {
    public int mySqrt(int x) {
        int l = 1 , r = x;
        while (l < r){
            int mid = l + r;
            if(x < mid * mid){
                r = mid - 1;
            }else{
                l = mid;
            }
        }
        return l;
    }
}
