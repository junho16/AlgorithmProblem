package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 357. 统计各位数字都不同的数字个数
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 *
 * @author Junho
 * @date 2022/4/11 14:22
 */
public class Main357 {
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(4));
    }
    public static int countNumbersWithUniqueDigits(int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return 10;
        if(n == 2)
            return 91;
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 9;
        res[2] = 91;
        for(int i = 3 ;i <= n ; i++){
            int k = 9;
            int num = 1 ;
            for(int j = 0 ; j < i ; j++){
                num *= k;
                if(j != 0)
                    k--;
            }
            res[i] = num + res[i-1];
        }
        return res[n];
    }
}
